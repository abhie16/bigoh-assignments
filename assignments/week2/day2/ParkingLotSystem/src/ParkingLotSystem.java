/*
 * MARk :- parking lot system class
 * DESC :- This class is used to create parking lot system
 */

import java.util.ArrayList;

import Floor.Floor;
import ParkingAttendant.Attendant;
import PaymentSystem.Payment;
import VehicleSpot.SpotAssignSystem;

public class ParkingLotSystem {

    private Floor defaultFloor;
    protected ArrayList<Floor> floorList;

    private Attendant defaultAttendat;
    protected ArrayList<Attendant> attendants;

    private Payment payment;


    public ParkingLotSystem(){

        payment = new Payment();

        defaultAttendat = new Attendant();

        floorList = new ArrayList<>();
        defaultFloor = new Floor();

        // adding default attendant i.e 1
        attendants.add(defaultAttendat);
        
        // adding default floor into list
        floorList.add(defaultFloor);
    }

    // park vehicle on basis of vehicle type and time
    public void park(String vehicleType, int timeForParking){
        Ticket ticket = buyTicket(timeForParking, vehicleType);
        if(ticket != null){
            System.out.println("Ticket is generated");
        }
        
    }

    // generate ticket on basis of vehicle type and time using ticket list
    public Ticket buyTicket(int timeForParking, String vehicleType){
        int floorCount = 0;
        for(Floor floor : floorList){
            // check floor is not full
            if(!floor.isFull()){

                // get assing spot of current floor to update it
                SpotAssignSystem spotInfo = floor.getSpotInfo();

                // check for vehicle type and update into it on that floor which has free space
                if(vehicleType.equals("Compact")){
                    if(spotInfo.getFreeCompactSpot() != 0){
                        spotInfo.setCompactSpot(spotInfo.getFreeCompactSpot() - 1);
                        break;
                    }
                    else{
                        continue;
                    }
                }
                if(vehicleType.equals("Large")){
                    if(spotInfo.getFreeLargeSpot() != 0){
                        spotInfo.setLargeSpot(spotInfo.getFreeLargeSpot() - 1);
                        break;
                    }
                    else{
                        continue;
                    }
                }
                if(vehicleType.equals("TwoWheeler")){
                    if(spotInfo.getFreeTwoWheelerSpot() != 0){
                        spotInfo.setTwoWheelerSpot(spotInfo.getFreeTwoWheelerSpot() - 1);
                        break;
                    }
                    else{
                        continue;
                    }
                }
                if(vehicleType.equals("Handicapped")){
                    if(spotInfo.getFreeHandicappedSpot() != 0){
                        spotInfo.setHandicappedSpot(spotInfo.getFreeHandicappedSpot() - 1);
                        break;
                    }
                    else{
                        continue;
                    }
                }
                if(vehicleType.equals("Electric Car")){
                    if(spotInfo.getFreeElectricCarSpot() != 0){
                        spotInfo.setElectricCarSpot(spotInfo.getFreeElectricCarSpot() - 1);
                        break;
                    }
                    else{
                        continue;
                    }
                }
            }
            else{
                floor.showBoard();
                floorCount++;
            }
        }

        if(floorCount<floorList.size()){
            Ticket ticket = new Ticket(timeForParking, vehicleType);
            return ticket;
        }
        else{
            System.out.println("All floor is full");
            return null;
        }
    }

    // scan ticket to tell price
    public void scanTicket(Ticket ticket){
        System.out.println("Ticket price is : " + ticket.getTicketPrice());;
    }

    // method to pay the ticket price
    public void pay(String paymentMethod, double amount, Ticket ticket){
        double ticketPrice = ticket.getTicketPrice();
        payment.makePayment(paymentMethod, amount, ticketPrice);
        if(payment.isSuccess()){
            ticket.setPaymentStatus(true);
        }
    }

    // method to pay to attendant
    public void payToAttendant(Ticket ticket, String paymentType, double amount){
        if(paymentType.equals("cash")){
            if(!ticket.isPaid()){
                if(amount >= ticket.getTicketPrice()){
                    payment.makePayment(paymentType, amount, ticket.getTicketPrice());
                }
                else if(amount < ticket.getTicketPrice()){
                    System.out.println("Please pay full amount");
                    return;
                }
                ticket.setPaymentStatus(true);
            }
            else{
                System.out.println("Ticket is already paid");
            }
        }
        else{
            System.out.println("only cash");
        }
    }

    // method to leave parking lot
    public void leaveParkingLot(Ticket ticket){
        if(ticket.isPaid()){
            
            // remove vehicle data from spot
            String vehicleType = ticket.getVehicleType();
            for(Floor floor : floorList){
                SpotAssignSystem spotInfo = floor.getSpotInfo();
                if(vehicleType.equals("Compact") ){
                    spotInfo.setCompactSpot(spotInfo.getFreeCompactSpot() + 1);
                    break;
                }
                if(vehicleType.equals("Large")){
                    spotInfo.setLargeSpot(spotInfo.getFreeLargeSpot() + 1);
                    break;
                }
                if(vehicleType.equals("TwoWheeler")){
                    spotInfo.setTwoWheelerSpot(spotInfo.getFreeTwoWheelerSpot() + 1);
                    break;
                }
                if(vehicleType.equals("Handicapped")){
                    spotInfo.setHandicappedSpot(spotInfo.getFreeHandicappedSpot() + 1);
                    break;
                }
                if(vehicleType.equals("Electric Car")){
                    spotInfo.setElectricCarSpot(spotInfo.getFreeElectricCarSpot() + 1);
                    break;
                }
            }

            System.out.println("Thank you for visiting");

        }
        else{
            System.out.println("Please pay the ticket price");
        }
    }

}
