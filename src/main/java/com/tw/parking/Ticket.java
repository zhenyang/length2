package com.tw.parking;

public class Ticket {
    private Car car;

    public Ticket(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }
}
