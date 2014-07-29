package com.tw.parking;

import com.google.common.base.Strings;

import java.util.ArrayList;

public class ParkingLot {
    private final ArrayList<Car> cars;
    private int size;

    public ParkingLot(int size) {
        this.size = size;
        this.cars = new ArrayList<Car>();
    }

    public Ticket park(Car car) {
        if (cars.size() == size) {
            return null;
        }
        cars.add(car);
        return new Ticket(car);
    }

    public Car unPark(Ticket ticket) {
        if (!cars.contains(ticket.getCar())) {
            return null;
        }
        cars.remove(ticket.getCar());
        return ticket.getCar();
    }

    public int getLeftLotSize() {
        return size - cars.size();
    }

    public double getEmptyRatio() {
        return getLeftLotSize() / cars.size();
    }

    public boolean isFull() {
        return size == cars.size();
    }

    public String report(int level) {
        return Strings.repeat("--", level) + "ParkingLot(" + cars.size() + "/" + size + ")\n";
    }
}
