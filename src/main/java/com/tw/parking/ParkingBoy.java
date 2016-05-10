package com.tw.parking;

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

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public String accept(Visitor visitor) {
        return visitor.visitParkable(this);
    }

}

