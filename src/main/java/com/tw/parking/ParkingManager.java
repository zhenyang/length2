package com.tw.parking;

import com.google.common.base.Splitter;

import java.util.List;

public class ParkingManager implements Parkable {
    private List<Parkable> parkingBoy;

    public ParkingManager(List<Parkable> parkingBoy) {
        this.parkingBoy = parkingBoy;
    }

    public Ticket park(Car car) {
        for (Parkable boy : parkingBoy) {
            Ticket ticket = boy.park(car);
            if (ticket != null) {
                return ticket;
            }
        }
        return null;
    }


    public Car unPark(Ticket ticket) {
        for (Parkable boy : parkingBoy) {
            Car car = boy.unPark(ticket);
            if (car != null) {
                return car;
            }
        }
        return null;
    }

    public String report() {
        StringBuilder result = new StringBuilder("ParkingManager\n");
        for (Parkable parkable : this.parkingBoy) {
            String report = parkable.report();
            Iterable<String> split = Splitter.on("\n").split(report);
            for (String s : split) {
                result.append("--").append(s).append("\n");
            }
        }
        return result.substring(0, result.length() - 1);
    }

}
