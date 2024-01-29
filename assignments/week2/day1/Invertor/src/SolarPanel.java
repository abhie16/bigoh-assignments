/*
 * MARK :- Solar panel class
 * DESC :- This class provide basic function for solar panel like setting number of panels, etc.
 */

public class SolarPanel {
    private int numberOfPanel;

    public SolarPanel(int numberOfPanel){
        setNumberOfPanel(numberOfPanel);
    }

    /* getter and setter for setting number of panels in solar panel */
    public void setNumberOfPanel(int numberOfPanel){
        this.numberOfPanel = numberOfPanel;
    }
    public int getNumberOfPanel(){
        return numberOfPanel;
    }
}
