package com.arjang.parking;

public abstract class ParkingLot {

    protected int parkingLotId ;
    protected String name;
    protected int parkingLotNumber;
    public boolean isTaken;
    protected Double costPerHour;
    protected boolean isVip;

    public ParkingLot(int parkingLotId, String name, int parkingLotNumber, boolean isTaken, Double costPerHour, boolean isVip) {
        this.parkingLotId = parkingLotId;
        this.name = name;
        this.parkingLotNumber = parkingLotNumber;
        this.isTaken = isTaken;
        this.costPerHour = costPerHour;
        this.isVip = isVip;
    }

    @Override
    public String toString() {
        return "{" +
                "\n Parking No = " + parkingLotNumber +
               ",\n Cost per Hour  = " + costPerHour +
                ",\n VIP = " + isVip +
                '}';
    }

    public int getParkingLotId() {
        return parkingLotId;
    }

    public String getName() {
        return name;
    }

    public int getParkingLotNumber() {
        return parkingLotNumber;
    }

    public boolean isTaken() {
        return isTaken;
    }

    public Double getCostPerHour() {
        return costPerHour;
    }

    public boolean isVip() {
        return isVip;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }
}
