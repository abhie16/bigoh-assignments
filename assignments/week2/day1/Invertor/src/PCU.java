/**
 * MARK :- PCU invertor class
 * DESC :- This class is extending solar intvertor class and have separate bussiness logic without grid on.
 */
public class PCU extends SolarInvertor {
    public PCU(){
        setName("PCU");
        setGridOnStatus(false);
    }
}