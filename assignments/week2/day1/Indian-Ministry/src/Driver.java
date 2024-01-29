/*
 * MARK :- Driver class
 * DESC :- Driver class extends Worker class and sets the type of worker to Driver
 */

public class Driver extends Worker {
    public Driver(String name){
        super(name);
    }

    public String getDriver(){
        return getName();
    }
}
