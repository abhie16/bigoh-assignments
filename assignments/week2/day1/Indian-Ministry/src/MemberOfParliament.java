/*
 * MARK :- class of Member of Parialment
 * DESC :- This class have method form expenses tracking, to vehicles assignment, for workers assign to mps
 */

import java.util.ArrayList;
import java.util.HashMap;

public class MemberOfParliament implements Person {

    private final int EXPENSE_LIMIT = 100000;
    private String name;
    private String constituency;
    private int spend;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private HashMap<String, Worker> workers = new HashMap<>();

    public boolean isPermitted = false;

    MemberOfParliament(String name){
        spend = 0;
        setName(name);
        setVehicle(new Car());
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    /* Method to set and get constituency of the mp */
    public void setConstituency(String constituency){
        this.constituency = constituency;
    }
    public String getConstituency(){
        return constituency;
    }

    /* Method to track and spend money provided to mp */
    public int getSpendMoney(){
        return spend;
    }
    public void setSpendMoney(int money){
        if(money < 0){
            System.out.println("Money can not be negative");
            return;
        }
        spend += money;
    }

    /* Check if money spend is more then provided money */
    public boolean exceedSpendingLimit(){
        return EXPENSE_LIMIT < spend ? true : false;
    }

    /* get and set name of the driver of car */
    public void setDriver(String driverName){
        workers.put("driver",new Driver(driverName));
    }
    public String getDriver(){
        return workers.get("driver").getName();
    }

    /* get and set vehicle */
    public void getVehicle(){
        for(Vehicle vehicle : vehicles){
            System.out.println(vehicle.getType());
        }
    }
    public void setVehicle(Vehicle vehicleType){
        vehicles.add(vehicleType);
    }
}
