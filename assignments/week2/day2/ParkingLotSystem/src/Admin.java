/*
 * MARK :- Admin class for parking lot
 * DESC :- This class is used to make admin for parking lot and it can add and remove floor, attendant, parking spots, entrance and exit panel
 */

 import Floor.Floor;
 import ParkingAttendant.Attendant;
 
 public class Admin {
 
     private int numberOfEntrance;
     private int numberOfExit;
 
     private ParkingLotSystem system;
     
     public Admin(ParkingLotSystem system) {
         this.system = system;
     }
 
     // add and remove floor by admin
     protected void addFloor(Floor floor){
         system.floorList.add(floor);
     }
     protected void removeFloor(){
         if(system.floorList.size()<2){
             System.out.println("One floor left");
             return;
         }
         system.floorList.remove(system.floorList.size()-1);
     }
 
     // add and remove attendant by admin
     protected void addAttendant(Attendant attendant){
         system.attendants.add(attendant);
     }
     protected void removeAttendant(){
         if(system.attendants.size()<2){
             System.out.println("One attendant left");
             return;
         }
         system.attendants.remove(system.attendants.size()-1);
     }
 
     // add and remove parking spots in floor
     protected void addSpots(Floor floor){
     }
     protected void removeSpots(Floor floor){
     }
 
     // add, remove and get entrance gate
     protected void addEntrance(){
         if(numberOfEntrance > 10){
             System.out.println("Too many Entrance gate");
             return;
         }
         numberOfEntrance++;
     }
     protected void removeEntrance(){
         if(numberOfEntrance<2){
             System.out.println("Can not be less then 1");
             return;
         }
         numberOfEntrance--;
     }
     protected int getNumberOfEntrance(){
         return numberOfEntrance;
     }
 
     // add, remove and get exit gate
     protected void addExit(){
         if(numberOfExit > 10){
             System.out.println("Too many Exit gate");
             return;
         }
         numberOfExit++;
     }
     protected void removeExit(){
         if(numberOfExit<2){
             System.out.println("Can not be less then 1");
             return;
         }
         numberOfExit--;
     }
     protected int getNumberOfExit(){
         return numberOfExit;
     }
     
 }
