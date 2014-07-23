package com.tw.parking;

import com.google.common.collect.Lists;
import com.tw.parking.chooser.SmartChooser;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class ParkingMasterTest {
    @Test
    public void test_should_park_car() throws Exception {
        ParkingLot parkingLot1 = Helper.createParkingLot(1, 5);
        ParkingLot parkingLot2 = Helper.createParkingLot(3, 10);
        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot1,parkingLot2);

        final List<ParkingLot> parkingLots1 = parkingLots;
        Parkable parkingBoy = new ParkingBoy(parkingLots1, new SmartChooser());
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        assertThat(parkingLot2.unPark(ticket), sameInstance(car));
    }

}
