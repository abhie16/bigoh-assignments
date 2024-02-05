
/**
 * MARK :- Hotel management system class
 * DESC :- This class is for hotel management system which feature of adding/deleting user, adding/deleting hotel, booking hotel with given number of rooms
 */

public class HotelManagementSystem {
    
    private HotelMangement hotelMangement;
    private UserMangement userMangement;
    
    // use to stor single instance of hotel mangement system ( singletong design ) as hotel system can be only one for all type of users.
    private static HotelManagementSystem instanceOfHotelManagementSystem = null;

    private HotelDatabase db ;

    // making constructor private to strict making more then one object of the hotel management system
    private HotelManagementSystem(){
        hotelMangement = new HotelMangement();
        userMangement = new UserMangement();
        db = HotelDatabase.getInstanceOfDB(); // get instance of db
    }
    
    // return single instance of hotel managment system
    public static HotelManagementSystem getInstance(){
        if(instanceOfHotelManagementSystem == null){
            instanceOfHotelManagementSystem = new HotelManagementSystem();
        }
        return instanceOfHotelManagementSystem;
    }
    
    // get user management instance
    public UserMangement getUserMangement(){
        return userMangement;
    }

    // get hotel management instance
    public HotelMangement getHotelMangement(){
        return hotelMangement;
    }
    
    // search hotel on basis of name and location entered by user into db
    public void search(String nameOfHotel, String locationOfHotel){
        db.search(nameOfHotel, locationOfHotel);
    }

    // verify hotel, save all hotel to db which is not verified
    public void verifyHotels(){
        hotelMangement.verifyHotels();
    }

    // book hotel of given name , location and number of rooms to book
    public Hotel bookHotel(String nameOfHotel, String locationOfHotel, int rooms){
        return hotelMangement.bookHotel(nameOfHotel, locationOfHotel, rooms);
    }

    // add hotel to db
    public void addHotel(Hotel hotel){
        hotelMangement.addHotel(hotel);
    }

    // delete hotel from db
    public void deleteHotel(Hotel hotel){
        hotelMangement.deleteHotel(hotel);
    }

    // update hotel details
    public void updateHotel(Hotel hotel){
        hotelMangement.addHotel(hotel);
    }

    // delete user from db
    public void deleteUser(User user){
        userMangement.deleteUser(user);
    }

    // add user to db
    public void addUser(String email, String name){
        userMangement.addUser(email, name);
    }
}
