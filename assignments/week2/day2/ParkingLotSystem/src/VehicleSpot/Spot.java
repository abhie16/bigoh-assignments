/*
 * MARK :- class for vehicle space
 * DESC :- This class is used to create vehicle space in parking lot of different sizes
 */

package VehicleSpot;

public class Spot {
    private boolean isOccupied;

    public Spot(){
        isOccupied=false;
    }

    /* getter and setter for occupying the vehicle spot */
    protected void setOccupiedStatus(boolean status){
        isOccupied = status;
    }
    protected boolean getOccupiedStatus(){
        return isOccupied;
    }
}
