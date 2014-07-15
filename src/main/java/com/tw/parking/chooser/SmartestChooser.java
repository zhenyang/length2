package com.tw.parking.chooser;

import com.tw.parking.ParkingLot;

import java.util.List;

public class SmartestChooser implements Chooser {
    public ParkingLot chooseParkingLot(List<ParkingLot> parkingLots1) {
        ParkingLot parkingLot = parkingLots1.get(0);
        for (int i = 1; i < parkingLots1.size(); i++) {
            ParkingLot temp = parkingLots1.get(i);
            if (temp.getEmptyRatio() > parkingLot.getEmptyRatio()) {
                parkingLot = temp;
            }
        }
        return parkingLot;
    }
}
