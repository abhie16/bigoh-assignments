/**
 * MARK :- GTI invertor class
 * DESC :- This class is extending solar intvertor class and have separate bussiness logic, withou battery.
 */
public class GTI extends SolarInvertor{
    public GTI(){
        setName("GTI");
        setBatteryAvailability(false);
    }
}