/**
 * MARK :- solar invertor class
 * DESC :- This class is extending invertor class, in addition it is providing some other feature like solar panel, etc.
 */
public class SolarInvertor extends Invertor{

    private boolean isGridOn;
    private SolarPanel solarPanel;

    public SolarInvertor(){
        isGridOn = true;
        setBatteryAvailability(true);
    }

    @Override
    public void setBatteryAvailability(boolean status) {
        super.setBatteryAvailability(status);
    }

    /* getter and setter for gridOn */
    public void setGridOnStatus(boolean status){
        isGridOn = status;
    }
    public boolean getGridOnStatus(){
        return isGridOn;
    }

    /* Getter and setter for solar panel */
    public void setNumberOfPanel(int numberOfPanel){
        solarPanel.setNumberOfPanel(numberOfPanel);
    }
    public int getNumberOfPanel(){
        return solarPanel.getNumberOfPanel();
    }
}