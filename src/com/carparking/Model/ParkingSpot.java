package com.carparking.Model;

public class ParkingSpot {

    private Integer floorNumber;
    private Integer slotNumber;
    private boolean isOccupied;
    private Vehicle vehicle;

    public ParkingSpot(Integer floorNumber, Integer slotNumber, boolean isOccupied) {
        this.floorNumber = floorNumber;
        this.slotNumber = slotNumber;
        this.isOccupied = isOccupied;
    }

    public Integer getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Integer floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Integer getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
