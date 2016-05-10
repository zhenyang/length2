package com.tw.parking;

import com.google.common.base.Strings;

public class Reporter implements Visitor {
    private int level;
    private final StringBuilder result;

    public Reporter() {
        this.level = 0;
        this.result = new StringBuilder();
    }

    public String visitParkable(ParkingManager parkingManager) {
        this.result.append(Strings.repeat("--", this.level)).append("ParkingManager\n");
        this.level++;
        for (Parkable parkable : parkingManager.getParkables()) {
            parkable.accept(this);
        }
        this.level--;
        return this.result.toString();
    }

    public String visitParkable(ParkingBoy parkingBoy) {
        this.result.append(Strings.repeat("--", this.level)).append("ParkingBoy\n");
        for (ParkingLot parkingLot : parkingBoy.getParkingLots()) {
            this.result.append(parkingLot.report(this.level + 1));
        }
        return this.result.toString();
    }
}
