/*
 * MARK :- Ticket class for parking lot
 * DESC :- This class is used to make ticket for parking lot
 */

public class Ticket {

    private int time;
    private boolean paymentStatus;

    private String vehicleType;

    private double firstHourPay;
    private double secondHourPay;
    private double payAfterTwoHour;

    public Ticket(int time, String vehicleType){

        firstHourPay = 4;
        secondHourPay = 3.5;
        payAfterTwoHour = 2.5;

        this.time = time;
        this.vehicleType = vehicleType;
        paymentStatus = false;
    }

    // get vehicle type
    protected String getVehicleType(){
        return vehicleType;
    }

    // return the total amount to be paid on basis of the time
    public double getTicketPrice(){
        double amount=0;
        if(0 < time && time>=1){
            amount += firstHourPay;
            --time;
        }
        if(0 < time && time>=1){
            amount += secondHourPay;
            --time;
        }
        if(time>0){
            amount += time * payAfterTwoHour;
        }

        return amount;
    }

    // getter and setter for payment status
    protected void setPaymentStatus(boolean paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
    protected boolean getPaymentStatus(){
        return paymentStatus;
    }

    // check if ticket is paid or not
    public boolean isPaid(){
        return paymentStatus;
    }

}
