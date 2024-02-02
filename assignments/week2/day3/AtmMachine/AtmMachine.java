package AtmMachine;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * MARK :- ATM Machine class
 * DESC :- This class is used to simulate the atm machine. It has top up method to initialize the atm machine with given number of notes and withdraw method to withdraw the money from atm machine.
 */
public class AtmMachine {

    private HashMap<Integer, Integer> denominationList;
    private long totalAmount;
    private ArrayList<Integer> typeOfNotes;
    private HashMap<Integer, Integer> listOfNotes;


    // constructor to initialize the atm machine
    public AtmMachine(){
        totalAmount = 0;
        typeOfNotes = new ArrayList<>();
        listOfNotes = new HashMap<>();
    }

    // top up method for atm machine
    public void topUp(HashMap<Integer, Integer> denominationList){
        this.denominationList = denominationList;
        initializeAmountInATM(denominationList);
    }

    // withdraw money from atm machine
    public void withdrawMoney(int amount){
        if(amount == 0){
            System.out.println("Enter amount");
            return;
        }
        if(amount > totalAmount){
            System.out.println("Insufficient amount into the atm");
            return;
        }
        else{
            if(processMoney(amount)){
                System.out.println("Amount withdrawn successfully");
                giveMoney(listOfNotes);
            }
            else return;
        }
    }

    // initiale the amount into atm machine with given number of notes
    private void initializeAmountInATM(HashMap<Integer, Integer> denominationsList){
        for(int note : denominationsList.keySet()){

            // if any note is present , then check the previous note and sort them in decreasing order then put in list
            if(typeOfNotes.size()>0){
                int previousNote = typeOfNotes.remove(typeOfNotes.size()-1);

                if(note > previousNote){
                    typeOfNotes.add(note);
                    typeOfNotes.add(previousNote);
                }
                else{
                    typeOfNotes.add(previousNote);
                    typeOfNotes.add(note);
                }
            }
            else typeOfNotes.add(note); // add note to list if no note is present


            totalAmount += denominationsList.get(note) * note;  // calculate total amount
        }
    }

    // process the given amount and return the number of notes required to withdraw
    private boolean processMoney(int amount){
        
        for(int note : typeOfNotes){
            if(amount >= note){
                int numberOfNotesRequired = amount/note;
                int numberOfNotesAvailable = denominationList.get(note);
                
                // check number of note present or not
                if( denominationList.get(note) == 0){
                    break;
                }
                if(numberOfNotesAvailable < numberOfNotesRequired){
                    amount = amount - (numberOfNotesAvailable * note);
                    totalAmount -= (numberOfNotesAvailable * note);
                    denominationList.put(note, 0);
                    listOfNotes.put(note,numberOfNotesAvailable);
                }
                else{
                    int numberOfNotesLeft = numberOfNotesAvailable - numberOfNotesRequired;
                    amount = amount - (numberOfNotesRequired * note);
                    totalAmount -= (numberOfNotesRequired * note);
                    denominationList.put(note , numberOfNotesLeft);
                    listOfNotes.put(note,numberOfNotesRequired);
                }               
            }
        }

        // if amount is not zero then means type of note is not present in atm --> print msg
        if(amount != 0){
            System.out.print("Please enter amount in multiple of ");
            for(int note : typeOfNotes){
                System.out.print(note+" ");
            } 
            System.out.println();
            return false;
        }

        return true;
    }

    // print number of notes after withdrawing amount from the atm
    private void giveMoney(HashMap<Integer, Integer> listOfNotes){
        for(int note : listOfNotes.keySet()){
            System.out.println( listOfNotes.get(note) + " notes of " + note);
        }
    }

    public static void main(String[] args) {
        AtmMachine obj = new AtmMachine();
        HashMap<Integer,Integer> amount = new HashMap<>();
        amount.put(200,10);
        amount.put(100, 5);

        obj.topUp(amount);
        System.out.println(obj.totalAmount);
        
        obj.withdrawMoney(550);
    }
}