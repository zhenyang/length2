package com.tw.parking;

import com.google.common.base.Strings;

import java.util.List;

public class Reporter {
    private int level;
    private final StringBuilder result;

    public Reporter() {
        this.level = 0;
        this.result = new StringBuilder();
    }

    String visitParkingManager(List<Parkable> parkables) {
        this.result.append(Strings.repeat("--", this.level)).append("ParkingManager\n");
        this.level++;
        for (Parkable parkable : parkables) {
            parkable.report(this);
        }
        this.level--;

        return this.result.toString();
    }

    String visitParkingBoy(List<ParkingLot> parkingLots) {
        this.result.append(Strings.repeat("--", this.level)).append("ParkingBoy\n");
        for (ParkingLot parkingLot : parkingLots) {
            this.result.append(parkingLot.report(this.level + 1));
        }
        return this.result.toString();
    }
}
