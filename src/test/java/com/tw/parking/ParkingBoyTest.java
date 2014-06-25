package com.tw.parking;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {
    @Test
    public void test_should_park_car() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        assertThat(parkingLot.unPark(ticket), sameInstance(car));
    }
}
