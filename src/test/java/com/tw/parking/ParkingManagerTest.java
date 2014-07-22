package com.tw.parking;

import com.google.common.collect.Lists;
import com.tw.parking.chooser.NormalChooser;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsSame.sameInstance;

public class ParkingManagerTest {
    @Test
    public void testShouldManageParkingBoy() throws Exception {
        ParkingLot parkingLot = Helper.createParkingLot(0, 1);
        ParkingBoy parkingBoy = new ParkingBoy(Lists.newArrayList(parkingLot), new NormalChooser());

        ParkingManager parkingManager = new ParkingManager(Lists.newArrayList(parkingBoy));

        Car car = new Car();
        Ticket ticket = parkingManager.park(car);


        assertThat(car, sameInstance(parkingManager.unPark(ticket)));
    }
}
