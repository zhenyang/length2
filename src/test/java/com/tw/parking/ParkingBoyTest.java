package com.tw.parking;

import com.google.common.collect.Lists;
import com.tw.parking.chooser.NormalChooser;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.IsSame.sameInstance;
import static org.junit.Assert.assertThat;

public class ParkingBoyTest {
    @Test
    public void test_should_park_car() throws Exception {
        ParkingLot parkingLot = new ParkingLot(1);
        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new NormalChooser());
        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        assertThat(parkingLot.unPark(ticket), sameInstance(car));
    }

    @Test
    public void test_should_park_to_first_non_full_lot() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot1,parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new NormalChooser());

        Car car = new Car();
        Ticket ticket = parkingBoy.park(car);

        assertThat(parkingLot2.unPark(ticket), sameInstance(car));
    }

    @Test
    public void test_should_unpark_car() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot1,parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new NormalChooser());
        Car car = new Car();
        Ticket ticket = parkingLot2.park(car);

        assertThat(parkingBoy.unPark(ticket), sameInstance(car));
    }

    @Test
    public void test_should_not_unpark_car_with_invalid_ticket() throws Exception {
        ParkingLot parkingLot1 = new ParkingLot(0);
        ParkingLot parkingLot2 = new ParkingLot(1);
        List<ParkingLot> parkingLots = Lists.newArrayList(parkingLot1,parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots, new NormalChooser());
        Car car = new Car();
        Ticket ticket = parkingLot2.park(car);

        assertThat(parkingBoy.unPark(new Ticket(new Car())), is(nullValue()));
    }
}
