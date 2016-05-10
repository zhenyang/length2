package com.tw.parking;

import java.util.List;

public class ParkingManager implements Parkable {
    private List<Parkable> parkables;

    public ParkingManager(List<Parkable> parkables) {
        this.parkables = parkables;
    }

    public Ticket park(Car car) {
        for (Parkable boy : parkables) {
            Ticket ticket = boy.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return null;
    }


    public Car unPark(Ticket ticket) {
        for (Parkable boy : parkables) {
            Car car = boy.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public List<Parkable> getParkables() {
        return parkables;
    }

    public String accept(Visitor visitor) {
        return visitor.visitParkable(this);
    }
}
