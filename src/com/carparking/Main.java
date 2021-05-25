package com.carparking;

import com.carparking.Exceptions.InvalidTicketException;
import com.carparking.Exceptions.ParkingFullException;
import com.carparking.Model.ParkingLot;
import com.carparking.Model.Ticket;
import com.carparking.Model.Vehicle;

public class Main {

    public static void main(String[] args) throws ParkingFullException, InvalidTicketException {
	// write your code here
        System.out.println("This is the main class");
        ParkingLot parkingLot = ParkingLot.INSTANCE;

        parkingLot.createParkingLot(2,4);
        Ticket ticket1 = parkingLot.parkVehicle(new Vehicle("MH45f3514"));

        System.out.println("grid: "+ parkingLot.getGrid());
        parkingLot.parkVehicle(new Vehicle("ap3dadas"));
        System.out.println("number of free slots : "+parkingLot.getNoOfFreeSlots());
        Vehicle v = parkingLot.getVehicle(ticket1);
        System.out.println("my unparked vehicle :"+v.getVehicleId());
        System.out.println("number of free slots : "+parkingLot.getNoOfFreeSlots());

    }
}
