package com.arjang.vehicles;

public class Car {
    protected int carId;
    protected String plateNumber;
    protected String type;

    public Car(int carId, String plateNumber, String type) {
        this.carId = carId;
        this.plateNumber = plateNumber;
        this.type = type;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "\n Car { " +
                "Model = '" + type + '\'' +",\n" +
                " Plate Number = '" + plateNumber + '\'' +
                '}';
    }
}
