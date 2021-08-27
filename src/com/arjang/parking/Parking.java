package com.arjang.parking;

import java.util.ArrayList;
import java.util.List;

//Parking class
public class Parking {
    private  int  parkingId;
    private String parkingName;
    private int workingHoursStart;
    private int workingHoursEnd;
    private int capacity;
    private List<ParkingFloor> parkingFloorList;

// Add constructor for making new parking class

    public Parking(int parkingId, String parkingName, int workingHoursStart, int workingHoursEnd, int capacity) {
        this.parkingId = parkingId;
        this.parkingName = parkingName;
        this.workingHoursStart = workingHoursStart;
        this.workingHoursEnd = workingHoursEnd;
        this.capacity = capacity;
        this.parkingFloorList = new ArrayList<>();
    }
//    Add Getters & Setters
        public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public int getWorkingHoursStart() {
        return workingHoursStart;
    }

    public void setWorkingHoursStart(int workingHoursStart) {
        this.workingHoursStart = workingHoursStart;
    }

    public int getWorkingHoursEnd() {
        return workingHoursEnd;
    }

    public void setWorkingHoursEnd(int workingHoursEnd) {
        this.workingHoursEnd = workingHoursEnd;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ParkingFloor> getParkingFloorList() {
        return parkingFloorList;
    }

    public void setParkingFloorList(List<ParkingFloor> parkingFloorList) {
        this.parkingFloorList = parkingFloorList;
    }
//    Add toString method for print

    @Override
    public String toString() {
        return "Parking{" +
                "parkingId=" + parkingId +
                ", parkingName='" + parkingName + '\'' +
                ", workingHoursStart=" + workingHoursStart +
                ", workingHoursEnd=" + workingHoursEnd +
                ", capacity=" + capacity +
                ", parkingFloor=" + parkingFloorList +
                '}';
    }

//    Adding new ParkingFloor to parking ArrayList
    public void addParkingFloor(ParkingFloor temParkingFloor){
        this.parkingFloorList.add(temParkingFloor);
    }
}
