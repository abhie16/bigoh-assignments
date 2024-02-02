/*
 * MARK :- Customer class for parking lot
 * DESC :- This class is used for customer for using service of parking lot
 */

public class Customer {
    public static void main(String[] args) {
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem();
        Ticket ticket = parkingLotSystem.buyTicket(2, "Compact");
    }
}
