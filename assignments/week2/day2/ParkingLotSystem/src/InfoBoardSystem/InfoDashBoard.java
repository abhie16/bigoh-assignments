/*
 * MARK :- SInfoDashBoard class for parking lot
 * DESC :- This class is used to show the information of parking lot for each floor
 */

package InfoBoardSystem;

import VehicleSpot.SpotAssignSystem;

public class InfoDashBoard {
    private SpotAssignSystem spotInfo;
    public InfoDashBoard(SpotAssignSystem spotInfo){
        this.spotInfo = spotInfo;
    }

    // display board for each floor in parking lot of its free spot and total spot
    public void displayBoardFloor(){
        System.out.println("Total Free Spot in this Floor: "+spotInfo.getTotalFreeSpot());
        System.out.println("Free spot for compact vehicle: "+spotInfo.getFreeCompactSpot());
        System.out.println("Free spot for Large vehicle: "+spotInfo.getFreeLargeSpot());
        System.out.println("Free spot for Handicapped vehicle: "+spotInfo.getFreeHandicappedSpot());
        System.out.println("Free spot for TwoWheeler vehicle: "+spotInfo.getFreeTwoWheelerSpot());
        System.out.println("Free spot for Electric car vehicle: "+spotInfo.getFreeElectricCarSpot());
    }
}
