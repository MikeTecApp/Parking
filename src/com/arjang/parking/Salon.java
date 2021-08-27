package com.arjang.parking;

import java.util.ArrayList;
import java.util.List;

public class Salon {
    private int salonId;
    private String name;
    private List<ParkingLot> parkingLotList;

//    Add constructor for creating salon class

    public Salon(int salonId, String name) {
        this.salonId = salonId;
        this.name = name;
        this.parkingLotList = new ArrayList<>();
    }

//    Add getter and setters

    public int getSalonId() {
        return salonId;
    }

    public void setSalonId(int salonId) {
        this.salonId = salonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }


//    Add toString method for print

    @Override
    public String toString() {
        return "Salon{" +
                "salonId=" + salonId +
                ", name='" + name + '\'' +
                ", parkingLotList=" + parkingLotList +
                '}';
    }
    //    Adding new ParkingLot(space) to salon ArrayList
    public void addParkingLot(ParkingLot tempParkingLot){
        this.parkingLotList.add(tempParkingLot);
    }
}
