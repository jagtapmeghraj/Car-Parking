package com.carparking.Model;

import com.carparking.Exceptions.InvalidTicketException;
import com.carparking.Exceptions.ParkingFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ParkingLot {

    private Integer noOfFreeSlots;
    private Integer noOfFloors;
    private Integer noOfSlotsPerFloor;
    private List<List<ParkingSpot>> grid;
    private HashSet<Ticket> ticketSet;

    public static ParkingLot INSTANCE = new ParkingLot();

    private ParkingLot() {
        grid = new ArrayList<>();
        ticketSet = new HashSet<>();
    }

    public void createParkingLot(Integer noOfFloors, Integer noOfSlotsPerFloor)
    {
        this.noOfFloors =noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        noOfFreeSlots = noOfFloors * noOfSlotsPerFloor;
        for(int i=0;i<noOfFloors;i++)
        {
            List<ParkingSpot> list = new ArrayList<>();
            for(int j=0;j<noOfSlotsPerFloor;j++)
            {
                list.add(new ParkingSpot(i,j,false));
            }
            grid.add(list);
        }
    }

    public Ticket parkVehicle(Vehicle vehicle) throws ParkingFullException
    {

        for(int i=0;i<noOfFloors;i++)
        {

            for(int j=0;j<noOfSlotsPerFloor;j++)
            {
                ParkingSpot parkingSpot = grid.get(i).get(j);
                if(!parkingSpot.isOccupied())
                {
                    parkingSpot.setOccupied(true);
                    parkingSpot.setVehicle(vehicle);
                    noOfFreeSlots--;
                    return generateTicket(vehicle, parkingSpot);
                }
            }
        }
        throw new ParkingFullException("Parking lot is full");
    }

    private Ticket generateTicket(Vehicle vehicle, ParkingSpot parkingSpot)
    {
            Integer floorNumber = parkingSpot.getFloorNumber();
            Integer slotNumber = parkingSpot.getSlotNumber();
            String tickedId = floorNumber.toString() + "-"+ slotNumber.toString();

            Ticket ticket = new Ticket(tickedId, vehicle, floorNumber, slotNumber);
            if(ticketSet.contains(ticket)){return null;}
            ticketSet.add(ticket);
            return ticket;
    }

    public Vehicle getVehicle(Ticket ticket) throws InvalidTicketException
    {
        if(!ticketSet.contains(ticket)){
            throw new InvalidTicketException("Invalid Ticket: This ticket wasnt generated");
        }
        Integer floorNumber = ticket.getFloorNumber();;
        Integer slotNumber = ticket.getSlotNumber();
        ParkingSpot parkingSpot = grid.get(floorNumber).get(slotNumber);
        Vehicle vehicle = parkingSpot.getVehicle();
        noOfFreeSlots++;
        parkingSpot.setOccupied(false);
        ticketSet.remove(ticket);
        return vehicle;
    }

    public Integer getNoOfFreeSlots() {
        return noOfFreeSlots;
    }

    public void setNoOfFreeSlots(Integer noOfFreeSlots) {
        this.noOfFreeSlots = noOfFreeSlots;
    }

    public List<List<ParkingSpot>> getGrid() {
        return grid;
    }

    public void setGrid(List<List<ParkingSpot>> grid) {
        this.grid = grid;
    }

    public HashSet<Ticket> getTicketSet() {
        return ticketSet;
    }

    public void setTicketSet(HashSet<Ticket> ticketSet) {
        this.ticketSet = ticketSet;
    }
}
