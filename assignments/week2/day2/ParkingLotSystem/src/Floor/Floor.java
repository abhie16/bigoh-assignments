/*
 * MARK :- Floor class for parking lot
 * DESC :- This class is used to create floor in parking lot with entrance and exit gate, and also assign spot to vehicle in floor which is by
 *          default 10 compact size, 5 large size, 5 handicapped size, 20 two wheeler size and 5 electric car size
 */

package Floor;

import InfoBoardSystem.InfoDashBoard;
import VehicleSpot.SpotAssignSystem;

public class Floor {

    private SpotAssignSystem spotAssignment;
    private InfoDashBoard board;

    public Floor(){
        // by default in each floor there are 10 compact size, 5 large size, 5 handicapped size, 20 two wheeler size and 5 electric car size
        spotAssignment = new SpotAssignSystem(10, 5, 5, 20, 5);
        board = new InfoDashBoard(spotAssignment);
    }

    // tell if floor is full or not
    public boolean isFull(){
        return spotAssignment.getTotalFreeSpot() == 0;
    }

    // get spot assign details
    public SpotAssignSystem getSpotInfo(){
        return spotAssignment;
    }

    // show info board
    public void showBoard(){
        board.displayBoardFloor();
    }
}
