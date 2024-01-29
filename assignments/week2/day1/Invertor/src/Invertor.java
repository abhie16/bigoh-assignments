/*
 * MARK :- Invertor class
 * DESC :- This invertor class is a parent class for all other invertor which provide basic functions to them like battery availability, current, voltage
*/
public class Invertor {

    private boolean isBatteryAvailable = true;
    private String name;
    private int current;
    private int operatingVoltage;

    public int powerRating(){
        return current * operatingVoltage;
    };

    /*getter and setter for invertor name */
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    /* getter and setter for setting the presence of battery in the invertor */
    public void setBatteryAvailability(boolean status){
        isBatteryAvailable = status;
    }
    public boolean getBatteryAvailability(){
        return isBatteryAvailable;
    }

    /* getter and setter for current */
    public void setCurrent(int current){
        this.current = current;
    }
    public int getCurrent(){
        return current;
    }

    /* getter and setter for voltage */
    public void setVoltage(int operatingVoltage){
        this.operatingVoltage = operatingVoltage;
    }
    public int getVoltage(){
        return operatingVoltage;
    }
}
