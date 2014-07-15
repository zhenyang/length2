package com.tw.parking.chooser;

import com.tw.parking.ParkingLot;

import java.util.List;

public class NormalChooser implements Chooser {

    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots1) {
        ParkingLot parkingLot = parkingLots1.get(0);
        for (int i = 1; i < parkingLots1.size(); i++) {
            if (parkingLot.isFull()) {
                parkingLot = parkingLots1.get(i);
            }
        }
        return parkingLot;
    }
}
