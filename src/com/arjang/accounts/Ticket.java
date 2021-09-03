package com.arjang.accounts;

import com.arjang.parking.ParkingLot;
import com.arjang.vehicles.Car;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ticket {
    private  int id;
    private Date enterDate;
    private Account account;
    private ParkingLot parkingLot;
    private Car vehicle;
    SimpleDateFormat dateFormat =new SimpleDateFormat("yyyy/MM/dd,    hh:mm a");

    public Ticket(int id) {
        this.id = id;
        this.enterDate = new Date();
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        if (parkingLot.isTaken()) {
            System.out.println("This parking is not empty...!");
        } else {
            this.parkingLot = parkingLot;
            this.parkingLot.isTaken = true;
        }
    }
    public Car getVehicle() {
        return vehicle;
    }

    public void setVehicle(Car vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public String toString() {
        return  "---------------------------------------------------" +
                "\n\n Enter Ticket{" +
                "No:" + id +
                ",\n Date & Time = " + dateFormat.format(enterDate) +
                ",\n  " + account +
                ",\n\n Park at" + parkingLot +
                ",\n " + vehicle +
                '}';
    }
}