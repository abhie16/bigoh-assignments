import java.util.ArrayList;

/**
 * MARK :- class for hotel
 * DESC :- This class provide basic features of hotel with setting thier name, location, rooms and rating. Provide serivce of booking room.
 */

public class Hotel {

    private String name;
    private String location;
    private int numberOfRooms;
    private ArrayList<String> facilities;

    private int hotelRating;
    private int ratingCounter;

    public Hotel(String name, String location, int numberOfRooms, ArrayList<String> facilities){
        hotelRating = 0;
        ratingCounter = 0;
        this.name = name;
        this.location = location;
        this.numberOfRooms = numberOfRooms;
        this.facilities = facilities;
    }

    // getter and setter for name of hotel
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }

    // getter and setter for location of hotel
    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return location;
    }

    // getter and setter for number of rooms in hotel
    public void setNumberOfRooms(int rooms){
        this.numberOfRooms = rooms;
    }
    public int getNumberOfRooms(){
        return numberOfRooms;
    }

    // get and set facilities of hotel
    public void setFacility(String facility){
        facilities.add(facility);
    }
    public ArrayList<String> getAllFacilities(){
        return facilities;
    }
    
    // show all info of hotel
    public void showHotel(){
        System.out.println("Name: "+name+", Location: "+location+", Rooms Available: "+numberOfRooms+", Rating: "+ getRating());
    }

    // book rooms and update number of room available
    public boolean bookRooms(int rooms){
        if(rooms > numberOfRooms){
            System.out.println("Rooms not available");
            return false;
        }
        numberOfRooms -= rooms;
        System.out.println("Rooms booked successfully");
        return true;
    }

    // set and get rating of hotel
    public void setRating(int rating){
        hotelRating += rating;
        ratingCounter++;
    }
    public int getRating(){
        return hotelRating/ratingCounter;
    }

}