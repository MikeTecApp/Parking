package com.arjang.parking;

public class NormalParkingLot extends ParkingLot{
    public NormalParkingLot(int parkingLotId,
                            String name,
                            int parkingLotNumber,
                            boolean isTaken,
                            Double costPerHour,
                            boolean isVip) {
        super(parkingLotId, name, parkingLotNumber, isTaken, costPerHour, isVip);
    }
}
