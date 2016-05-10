package com.tw.parking;

import com.google.common.collect.Lists;
import com.tw.parking.chooser.NormalChooser;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsSame.sameInstance;

public class ParkingManagerTest {
    @Test
    public void testShouldManageParkingBoy() throws Exception {
        ParkingLot parkingLot = Helper.createParkingLot(0, 1);
        Parkable parkingBoy = new ParkingBoy(Lists.newArrayList(parkingLot), new NormalChooser());

        Parkable parkingManager = new ParkingManager(Lists.newArrayList(parkingBoy));

        Car car = new Car();
        Ticket ticket = parkingManager.park(car);


        assertThat(car, sameInstance(parkingManager.unPark(ticket)));
    }

    @Test
    public void testShouldReport() throws Exception {
        ParkingLot parkingLot1 = Helper.createParkingLot(1, 7);
        ParkingLot parkingLot2 = Helper.createParkingLot(2, 8);
        Parkable parkingBoy = new ParkingBoy(Lists.newArrayList(parkingLot1,parkingLot2), new NormalChooser());

        ParkingLot parkingLot3 = Helper.createParkingLot(1, 7);
        ParkingLot parkingLot4 = Helper.createParkingLot(2, 8);
        Parkable parkingBoy2 = new ParkingBoy(Lists.newArrayList(parkingLot3,parkingLot4), new NormalChooser());

        Parkable parkingManager = new ParkingManager(Lists.newArrayList(parkingBoy,parkingBoy2));
        Parkable parkingManager2 = new ParkingManager(Lists.newArrayList(parkingManager));


        String result = "ParkingManager\n" +
                "--ParkingManager\n" +
                "----ParkingBoy\n" +
                "------ParkingLot(1/7)\n" +
                "------ParkingLot(2/8)\n" +
                "----ParkingBoy\n" +
                "------ParkingLot(1/7)\n" +
                "------ParkingLot(2/8)\n" ;

        String accept = parkingManager2.accept(new Reporter());
        assertThat(accept, is(result));
    }
}
