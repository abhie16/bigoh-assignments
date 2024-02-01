/*
 * MARK :- Payment class for parking lot
 * DESC :- This class is used for payment service in parking lot
 */

package PaymentSystem;



public class Payment{

    private boolean paymentStatus = false;
    
    // make payment
    public Payment(){
        paymentStatus = false;
    }
    
    public void makePayment(String paymentType, double amount, double ticketPrice){
        if(paymentType.equals("cash")){
            if(amount == ticketPrice) paymentStatus = true;
            else{
                paymentStatus = true;
                System.out.println("Return money: "+(amount-ticketPrice));
            }
        }
        else if(paymentType.equals("credit")){
            // after making credit payment
            System.out.println("Enter credit card for payment");
            paymentStatus = true;
        }
        else{
            System.out.println("Invalid payment type");
        }
        
    }

    // tell if payment is successful or not
    public boolean isSuccess(){
        return paymentStatus;
    }
}
