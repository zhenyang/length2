package com.tw.parking;

import com.google.common.base.Splitter;
import com.tw.parking.chooser.Chooser;

import java.util.List;

public class ParkingBoy implements Parkable {
    private final Chooser chooser;
    protected List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots, Chooser chooser) {
        this.parkingLots = parkingLots;
        this.chooser = chooser;
    }

    public Ticket park(Car car) {
        ParkingLot parkingLot = this.chooser.chooseParkingLot(parkingLots);
        return parkingLot.park(car);
    }

    public Car unPark(Ticket ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            Car car = parkingLot.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder result = new StringBuilder("");
        result.append("ParkingBoy\n");
        for (ParkingLot parkingLot : parkingLots) {
            String report = parkingLot.report();
            Iterable<String> split = Splitter.on("\n").split(report);
            for (String s : split) {
                result.append("--").append(s).append("\n");
            }
        }
        result.delete(result.length() - 1, result.length());
        return result.toString();
    }

}

