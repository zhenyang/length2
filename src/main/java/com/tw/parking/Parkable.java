package com.tw.parking;

public interface Parkable {
    Ticket park(Car car);

    Car unPark(Ticket ticket);

    String accept(Visitor visitor);
}
