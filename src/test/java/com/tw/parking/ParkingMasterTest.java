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
        ParkingLot parkingLot1 = createParkingLot(1, 5);
        ParkingLot parkingLot2 = createParkingLot(3, 10);
        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot1,parkingLot2);

        final List<ParkingLot> parkingLots1 = parkingLots;
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots1, new SmartChooser());
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        assertThat(parkingLot2.unPark(ticket), sameInstance(car));
    }

    private ParkingLot createParkingLot(int parkedCars, int size) {
        ParkingLot parkingLot = new ParkingLot(size);
        for (int i = 0; i < parkedCars; i++) {
            Car car = new Car();
            parkingLot.park(car);
        }
        return parkingLot;
    }

//    @Test
//    public void test_should_park_to_first_non_full_lot() throws Exception {
//        ParkingLot parkingLot1 = new ParkingLot(0);
//        ParkingLot parkingLot2 = new ParkingLot(1);
//        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot1,parkingLot2);
//        ParkingMaster parkingBoy = new ParkingMaster(parkingLots);
//
//        Car car = new Car();
//        Ticket ticket = parkingBoy.park(car);
//
//        assertThat(parkingLot2.unPark(ticket), sameInstance(car));
//    }
//
//    @Test
//    public void test_should_unpark_car() throws Exception {
//        ParkingLot parkingLot1 = new ParkingLot(0);
//        ParkingLot parkingLot2 = new ParkingLot(1);
//        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot1,parkingLot2);
//        ParkingMaster parkingBoy = new ParkingMaster(parkingLots);
//        Car car = new Car();
//        Ticket ticket = parkingLot2.park(car);
//
//        assertThat(parkingBoy.unPark(ticket), sameInstance(car));
//    }
//
//    @Test
//    public void test_should_not_unpark_car_with_invalid_ticket() throws Exception {
//        ParkingLot parkingLot1 = new ParkingLot(0);
//        ParkingLot parkingLot2 = new ParkingLot(1);
//        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot1,parkingLot2);
//        ParkingMaster parkingBoy = new ParkingMaster(parkingLots);
//        Car car = new Car();
//        Ticket ticket = parkingLot2.park(car);
//
//        assertThat(parkingBoy.unPark(new Ticket(new Car())), is(nullValue()));
//    }
}
