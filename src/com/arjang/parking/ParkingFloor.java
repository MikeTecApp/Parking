package com.arjang.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {

    private int parkingFloorId;
    private String levelName;
    private int capacity;
    private List<Salon> salonsList;

    //    Add constructor for creating new class
    public ParkingFloor(int parkingFloorId, String levelName, int capacity) {
        this.parkingFloorId = parkingFloorId;
        this.levelName = levelName;
        this.capacity = capacity;
        this.salonsList = new ArrayList<>();
    }
//       Add getter and Setter

    public int getParkingFloorId() {
        return parkingFloorId;
    }

    public void setParkingFloorId(int parkingFloorId) {
        this.parkingFloorId = parkingFloorId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Salon> getSalonsList() {
        return salonsList;
    }

    public void setSalonsList(List<Salon> salonsList) {
        this.salonsList = salonsList;
    }
//Add toString method for print
    @Override
    public String toString() {
        return "ParkingFloor{" +
                "parkingFloorId=" + parkingFloorId +
                ", levelName='" + levelName + '\'' +
                ", capacity=" + capacity +
                ", salonsList=" + salonsList +
                '}';
    }
    //    Adding new Parking Salon to parkingFloor ArrayList
    public void addSalon(Salon tempSalon){
        this.salonsList.add(tempSalon);
    }
}
