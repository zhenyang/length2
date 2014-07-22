package com.tw.parking;

import com.google.common.collect.Lists;
import com.tw.parking.chooser.SmartestChooser;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class ParkingDoctorTest {
    @Test
    public void test_should_park_car() throws Exception {
        ParkingLot parkingLot1 = Helper.createParkingLot(3, 10);
        ParkingLot parkingLot2 = Helper.createParkingLot(1, 5);
        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot1,parkingLot2);

        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new SmartestChooser());
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        assertThat(parkingLot2.unPark(ticket), sameInstance(car));
    }
}
