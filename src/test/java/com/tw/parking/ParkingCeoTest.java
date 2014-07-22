package com.tw.parking;

import com.google.common.collect.Lists;
import com.tw.parking.chooser.NormalChooser;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class ParkingCeoTest {
    @Test
    public void testShouldManageParkingBoy() throws Exception {
        ParkingLot parkingLot = Helper.createParkingLot(0, 1);
        ParkingBoy parkingBoy = new ParkingBoy(Lists.newArrayList(parkingLot), new NormalChooser());

        ParkingManager parkingManager = new ParkingManager(Lists.newArrayList(parkingBoy));

        ParkingCeo parkingCeo = new ParkingCeo(Lists.newArrayList(parkingManager));

        Car car = new Car();
        Ticket ticket = parkingCeo.park(car);


        assertThat(car, sameInstance(parkingCeo.unPark(ticket)));
    }
}
