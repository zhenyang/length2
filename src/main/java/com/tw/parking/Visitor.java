package com.tw.parking;

public interface Visitor {
    String visitParkable(ParkingManager parkingManager);

    String visitParkable(ParkingBoy parkingBoy);
}
