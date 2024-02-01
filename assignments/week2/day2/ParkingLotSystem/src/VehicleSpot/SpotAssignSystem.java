/*
 * MARK :- SpotAssignSystem
 * DESC :- This class is used to assign spot in the floor
 */

package VehicleSpot;

import java.util.ArrayList;

public class SpotAssignSystem {

    private ArrayList<CompactSizeSpot> compactSizeSpots;
    private ArrayList<ElectricVehicleSpot> electricVehicleSpots;
    private ArrayList<HandicappedSizeSpot> handicappedSizeSpots;
    private ArrayList<LargeSizeSpot> largeSizeSpots;
    private ArrayList<TwoWheelerSpot> twoWheelerSpots;

    public SpotAssignSystem(int numberOfCompactSize, int numberOfLargeSize, int numberOfHandicappedSize, int numberOfTwoWheelerSize, int numberOfElectricCars){

        for(int spot=0; spot<numberOfCompactSize; spot++){
            compactSizeSpots.add(new CompactSizeSpot());
        }
        for(int spot=0; spot<numberOfElectricCars; spot++){
            electricVehicleSpots.add(new ElectricVehicleSpot());
        }
        for(int spot=0; spot<numberOfLargeSize; spot++){
            largeSizeSpots.add(new LargeSizeSpot());
        }
        for(int spot=0; spot<numberOfHandicappedSize; spot++){
            handicappedSizeSpots.add(new HandicappedSizeSpot());
        }
        for(int spot=0; spot<numberOfTwoWheelerSize; spot++){
            twoWheelerSpots.add(new TwoWheelerSpot());
        }

    }

    // +++++++ Total size and total free spot +++++++
    public int getTotalSpotAssign(){
        return compactSizeSpots.size() + electricVehicleSpots.size() + handicappedSizeSpots.size() + largeSizeSpots.size() + twoWheelerSpots.size();
    }
    
    public int getTotalFreeSpot(){
        return getFreeCompactSpot() + getFreeElectricCarSpot() + getFreeHandicappedSpot() + getFreeLargeSpot() + getFreeTwoWheelerSpot();
    }

    // +++++++ Compact Size +++++++ 

    /* explicitly add compact size spot */
    public void setCompactSpot(int numberOfCompactSize){
        for(int spot=0; spot<numberOfCompactSize; spot++){
            compactSizeSpots.add(new CompactSizeSpot());
        }
    }
    /* get number of compact spot */
    public int getTotalCompactSpot(){
        return compactSizeSpots.size();
    }
    /* get free number of compact spot */
    public int getFreeCompactSpot(){
        int count=0;
        for(CompactSizeSpot spot : compactSizeSpots){
            if(!spot.getOccupiedStatus()) count++;
        }
        return count;
    }

    // +++++++ Large Size +++++++ 

    /* explicitly add large size spot */
    public void setLargeSpot(int numberOfLargeSize){
        for(int spot=0; spot<numberOfLargeSize; spot++){
            largeSizeSpots.add(new LargeSizeSpot());
        }
    }
    /* get number of large spot */
    public int getTotalLargeSpot(){
        return largeSizeSpots.size();
    }
    /* get free number of large spot */
    public int getFreeLargeSpot(){
        int count=0;
        for(LargeSizeSpot spot : largeSizeSpots){
            if(!spot.getOccupiedStatus()) count++;
        }
        return count;
    }

    // +++++++ Compact Size +++++++ 

    /* explicitly add Handicapped size spot */
    public void setHandicappedSpot(int numberOfHandicappedSize){
        for(int spot=0; spot<numberOfHandicappedSize; spot++){
            handicappedSizeSpots.add(new HandicappedSizeSpot());
        }
    }
    /* get number of Handicapped spot */
    public int getTotalHandicappedSpot(){
        return handicappedSizeSpots.size();
    }
    /* get free number of handicapped spot */
    public int getFreeHandicappedSpot(){
        int count=0;
        for(HandicappedSizeSpot spot : handicappedSizeSpots){
            if(!spot.getOccupiedStatus()) count++;
        }
        return count;
    }

    // +++++++ TwoWheeler Size +++++++ */

    /* explicitly add two wheeler size spot */
    public void setTwoWheelerSpot(int numberOfTwoWheelerSize){
        for(int spot=0; spot<numberOfTwoWheelerSize; spot++){
            twoWheelerSpots.add(new TwoWheelerSpot());
        }
    }
    /* get number of Two Wheeler spot */
    public int getTotalTwoWheelerSpot(){
        return twoWheelerSpots.size();
    }
    /* get free number of two wheeler spot */
    public int getFreeTwoWheelerSpot(){
        int count=0;
        for(TwoWheelerSpot spot : twoWheelerSpots){
            if(!spot.getOccupiedStatus()) count++;
        }
        return count;
    }

    // +++++++ ElectricCars Size +++++++ */

    /* explicitly add ElectricCars size spot */
    public void setElectricCarSpot(int numberOfElectricCars){
        for(int spot=0; spot<numberOfElectricCars; spot++){
            electricVehicleSpots.add(new ElectricVehicleSpot());
        }
    }
    /* get number of ElectricCars spot */
    public int getTotalElectricCarSpot(){
        return electricVehicleSpots.size();
    }
    /* get free number of ElectricCars spot */
    public int getFreeElectricCarSpot(){
        int count=0;
        for(ElectricVehicleSpot spot : electricVehicleSpots){
            if(!spot.getOccupiedStatus()) count++;
        }
        return count;
    }

}
