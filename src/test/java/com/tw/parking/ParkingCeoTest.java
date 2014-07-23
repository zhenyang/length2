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
        Parkable parkingBoy = new ParkingBoy(Lists.newArrayList(parkingLot), new NormalChooser());

        Parkable parkingManager = new ParkingManager(Lists.newArrayList(parkingBoy));

        Parkable parkingCeo = new ParkingManager(Lists.newArrayList(parkingManager));

        Car car = new Car();
        Ticket ticket = parkingCeo.park(car);


        assertThat(car, sameInstance(parkingCeo.unPark(ticket)));
    }
}
