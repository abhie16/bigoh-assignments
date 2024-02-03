import java.util.ArrayList;

/**
 * MARK :- Hotel management system class
 * DESC :- This class is for hotel management system which feature of adding/deleting user, adding/deleting hotel, booking hotel with given number of rooms
 */

public class HotelManagementSystem {
    
    // store hotel added by agent
    public ArrayList<Hotel> unVerifiedHotel;

    // use to stor single instance of hotel mangement system ( singletong design ) as hotel system can be only one for all type of users.
    private static HotelManagementSystem instanceOfHotelManagementSystem = null;

    private HotelDatabase db ;

    // making constructor private to strict making more then one object of the hotel management system
    private HotelManagementSystem(){
        unVerifiedHotel = new ArrayList<>();
        db = HotelDatabase.getInstanceOfDB(); // get instance of db
    }
    
    // return single instance of hotel managment system
    public static HotelManagementSystem getInstance(){
        if(instanceOfHotelManagementSystem == null){
            instanceOfHotelManagementSystem = new HotelManagementSystem();
        }
        return instanceOfHotelManagementSystem;
    }

    // add and delete user form db
    public void addUser(String email, String name){
        db.addUser(email, name);
    }
    public void deleteUser(User user){
        db.deleteUser(user);
    }

    // add hotel for agent 
    public void addHotel(Hotel hotel){
        unVerifiedHotel.add(hotel);
    }
    // add and delete hotel from db
    public void addHotelToDB(Hotel hotel){
        db.addHotel(hotel);
    }
    public void deleteHotel(Hotel hotel){
        db.deleteHotel(hotel);
    }
    
    // search hotel on basis of name and location entered by user into db
    public void search(String nameOfHotel, String locationOfHotel){
        for(String hotelName : db.hotelList.keySet()){
            if(hotelName.equals(nameOfHotel)){
                db.hotelList.get(nameOfHotel).showHotel();
            }
            if(db.hotelList.get(hotelName).getLocation().equals(locationOfHotel)){
                db.hotelList.get(hotelName).showHotel();
            }
        }
    }

    // book hotel of given name , location and number of rooms to book
    public Hotel bookHotel(String nameOfHotel, String locationOfHotel, int rooms){
        if(db.hotelList.containsKey(nameOfHotel)){
            // check if room successfully booked
            if(db.hotelList.get(nameOfHotel).bookRooms(rooms)){
                return db.hotelList.get(nameOfHotel); // return hotel in which room is booked , here we can also use hotelID by adding them into hotel class
            }
            return null;
        }
        else{
            System.out.println("Hotel does not exist");
            return null;
        }
    }
}
