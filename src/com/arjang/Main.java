package com.arjang;

import com.arjang.accounts.*;
import com.arjang.parking.*;
import com.arjang.vehicles.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static final String DB_NAME = "parking.db";
    public static final String CONECTION_STRING = "jdbc:sqlite:D:\\Programs\\Projects\\Java\\Parking\\src\\"+DB_NAME;

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(CONECTION_STRING);
            Statement statement = conn.createStatement();)
        {
            statement.execute("SELECT ticket.ticketId, parkingFloor.levelName, salon.salonName, parkingLot.parkingLotNumber , car.type, " +
                    "car.plateNumber,ticket.enterDate, account.accountType " +
                    "FROM parkingLot " +
                    "INNER JOIN car " +
                    "ON parkingLot.parkingLotId = car.parkinglotId " +
                    "INNER JOIN salon " +
                    "ON parkingLot.salonId = salon.salonId " +
                    "INNER JOIN parkingFloor  " +
                    "ON salon.parkingFloorId = parkingFloor.parkingFloorId " +
                    "INNER JOIN ticket " +
                    "ON ticket.carId = car.carId " +
                    "INNER join account " +
                    "ON account.accountId = ticket.accountID " +
                    "order by ticketId");
           ResultSet resultSet = statement.getResultSet();
           while (resultSet.next()){
               System.out.println("Ticket Id = " + resultSet.getInt("ticketId"));
               System.out.print("levelName: " + resultSet.getString("levelName")+",\t");
               System.out.print("salonName: " + resultSet.getString("salonName")+",\t");
               System.out.print("parking:" + resultSet.getString("parkingLotNumber")+",\t");
               System.out.print("Model: " + resultSet.getString("type")+",\t");
               System.out.print("pelak: " + resultSet.getString("plateNumber")+",\t");
               System.out.print("tarikh: " + resultSet.getString("enterDate")+",\t");
               System.out.print("account: " + resultSet.getString("accountType")+"\n\n");

           }
  /*           while (resultSet.next()){
                System.out.println("Car ID: "+resultSet.getInt("carId"));
                System.out.print(" parked at parkinglot ID: " + resultSet.getInt("parkingLotId"));
                System.out.print("- Car's plate number is: " + resultSet.getString("plateNumber"));
                System.out.print(" and Model : " + resultSet.getString("type") + "\n ");
                }*/



        } catch (SQLException e) {
            System.out.println(" ----------- DB connection Error !!! -----------");
            e.printStackTrace();
        }


    }

    private static Ticket findTiketForParking(Parking funParking, String parkingName, List<Ticket> ticketList) {
        ParkingLot lot =  findParkingLot (funParking,parkingName);
        for (Ticket ticket:ticketList  ) {
            if (lot != null && ticket.getParkingLot().getParkingLotId() == lot.getParkingLotId()) {
                System.out.println(ticket);
                return ticket;

            }
        }
        System.out.println("Sorry Can Not find the ticket");
        return null;
    }

//  Find all using parking
    private static ParkingLot findParkingLot (Parking funParking,String parkingName){
        List<ParkingFloor> floors = funParking.getParkingFloorList();
        for (ParkingFloor floor:floors){
            List<Salon> salons = floor.getSalonsList();
            for(Salon salon : salons){
                List<ParkingLot> parkings = salon.getParkingLotList();
                for (ParkingLot parking: parkings){
                    if (parking.getName().equals(parkingName)) {
                        System.out.println(parking);
                        return  parking;
                    }
                }
            }
        }
        System.out.println("Parking lot not found !!! :(");
        return null;
    }
    private static void parkingInfo(Parking funParking, String parkingName) {
                    ParkingLot lot =  findParkingLot (funParking,parkingName);
                    if (lot != null && lot.getName().equals(parkingName)) {
                        System.out.println(" Information: parking " + lot.getName() + " Number: " + lot.getParkingLotId());
                    }
        }

//  Find all using parking
    private static void allUseingParkings(Parking funParking) {
        List<ParkingFloor> floors = funParking.getParkingFloorList();
        for (ParkingFloor floor:floors){
            List<Salon> salons = floor.getSalonsList();
            for(Salon salon : salons){
                List<ParkingLot> parkings = salon.getParkingLotList();
                for (ParkingLot parking: parkings){
                    if (parking.isTaken)
                        System.out.println("parking " + parking.getName() + " Number: " + parking.getParkingLotId()
                                + " in Salon " + salon.getName() + " in " + floor.getLevelName() + " is busy");
                }
            }
        }

    }

//  Get available parking list
    private static void availabelParkins (Parking funParking) {

        List<ParkingFloor> floors = funParking.getParkingFloorList();
        for (ParkingFloor floor:floors){
            List<Salon> salons = floor.getSalonsList();
            for(Salon salon : salons){
                List<ParkingLot> parkings = salon.getParkingLotList();
                for (ParkingLot parking: parkings){
                    if (!parking.isTaken)
                    System.out.println("parking " + parking.getName() + " Number: " + parking.getParkingLotId()
                            + " in Salon " + salon.getName() + " in " + floor.getLevelName() + "is empty");
                }
            }
        }

    }
//  Get all parking list
    private static void allParkigList(Parking funParking) {

        List<ParkingFloor> floors = funParking.getParkingFloorList();
        for (ParkingFloor floor:floors)
        {
            List<Salon> salons = floor.getSalonsList();
            for(Salon salon : salons){
                List<ParkingLot> parkings = salon.getParkingLotList();
                for (ParkingLot parking: parkings){
                    System.out.println("parking " + parking.getName() + " Number: " + parking.getParkingLotId()
                            + " in Salon " + salon.getName() + " in " + floor.getLevelName() );
                }
            }
        }

    }

    private void loadData (){

/*        ------------------------Start---------
//      Main Class Variables
        String  parkingName;
        List<Ticket>ticketList = new ArrayList<>();

//      Create Scanner object for data entry
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Welcome to the parking mode......");

//      Creating Vip ParkingLot
        VipParkingLot vip1 = new VipParkingLot(1,"Vip1",11,false,10.00,true);
        VipParkingLot vip2 = new VipParkingLot(2,"Vip2",12,false,10.00,true);
        VipParkingLot vip3 = new VipParkingLot(3,"Vip3",13,false,10.00,true);

//      Creating Normal parkingLot
        ParkingLot lot1 = new NormalParkingLot(4,"Norm1",14,false,5.50,false);
        ParkingLot lot2 = new NormalParkingLot(5,"Norm2",15,false,5.50,false);
        ParkingLot lot3 = new NormalParkingLot(6,"Norm3",16,false,5.50,false);
        ParkingLot lot4 = new NormalParkingLot(7,"Norm4",17,false,5.50,false);
        ParkingLot lot5 = new NormalParkingLot(8,"Norm5",18,false,5.50,false);
        ParkingLot lot6 = new NormalParkingLot(9,"Norm6",19,false,5.50,false);

//      Create Salon A for the first Floor and add parking to it
        Salon salonA = new Salon(1,"A");
        salonA.addParkingLot(vip1);
        salonA.addParkingLot(lot1);
        salonA.addParkingLot(lot2);
        salonA.addParkingLot(lot3);

//      Create Salon B for the Second Floor and add parking to it
        Salon salonB = new Salon(1,"B");
        salonB.addParkingLot(vip2);
        salonB.addParkingLot(vip3);
        salonB.addParkingLot(lot4);
        salonB.addParkingLot(lot5);
        salonB.addParkingLot(lot6);

//      Create first Floor and assign salon A to it
        ParkingFloor firstFloor = new ParkingFloor(1,"First Floor",10);
        firstFloor.addSalon(salonA);

//      Create Second Floor and assign salon B to it
        ParkingFloor secondFloor = new ParkingFloor(2,"Second Floor",10);
        secondFloor.addSalon(salonB);

//      Create completed Parking name:Fun Parking!
        Parking funParking = new Parking(1,"Fun Parking",8,24,1000);
        funParking.addParkingFloor(firstFloor);
        funParking.addParkingFloor(secondFloor);

//      Create Daily Account
        Account dailyAcc = new DailyAccount(1);
        dailyAcc.initAccount("Mohammadi");
        dailyAcc.addAccountBalance();

//      Create three month  Account
        Account threeMonthsAcc = new ThreeMonthAccount(2);
        threeMonthsAcc.initAccount("joharFar");
        threeMonthsAcc.addAccountBalance();

//      Create Six months Account
        Account sixMonthAcc = new SixMonthAccount(3);
        sixMonthAcc.initAccount("Javadi");
        sixMonthAcc.addAccountBalance();

//      Create Cars ...
        Car pride = new Car(1,"23 B 456","pride");
        Car peugeot206 = new Car(2,"18 N 519","Peugeot 206");
        Car peugeot405 = new Car(3,"88 L 149","Peugeot 405");
        Car volvo = new Car(4,"77 V 777","Volvo");

//      Create 1st Ticket
        Ticket firstTicket = new Ticket(1);
        firstTicket.setParkingLot(lot1);
        firstTicket.setAccount(dailyAcc);
        firstTicket.setVehicle(pride);
        ticketList.add(firstTicket);
//        System.out.println(firstTicket);

//       Create 2nd Ticket
        Ticket secondTicket = new Ticket(2);
        secondTicket.setParkingLot(lot2);
        secondTicket.setAccount(threeMonthsAcc);
        secondTicket.setVehicle(volvo);
        ticketList.add(secondTicket);
//        System.out.println(secondTicket);

//        Get all parking list
//        allParkigList(funParking);

//        Get free parking list
//        availabelParkins(funParking);

//        Find all using parking
//        allUseingParkings(funParking);

//        parking Name Example for finding parking(test)
        parkingName="Norm1";
//        Information about one Parking
//        parkingInfo(funParking,parkingName);

//        find Ticket for specific Parking
        findTiketForParking(funParking,parkingName,ticketList);

//      Creating main menu( Not complete!!! )
//       System.out.println(" would you like update entry data ?");
//       String input = scanner.nextLine();
//       System.out.println(input);

        -----------------------END------------------------*/
    }

}