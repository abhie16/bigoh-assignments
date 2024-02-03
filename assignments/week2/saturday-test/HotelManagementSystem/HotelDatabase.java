import java.util.HashMap;

/**
 * MARK :- database class
 * DESC :- This class is used as a db for hotel management system with funcitonality of adding/deleting user and hotel into db using hashmap.
 */

public class HotelDatabase {

    public HashMap<String, Hotel> hotelList;
    private HashMap<String,String> userList;

    // use to store single instance of database ( singletong design ) as database can be only one.
    private static HotelDatabase instanceOfDB = null;

    // making constructor private to strict making more then one object of the db
    private HotelDatabase(){
        hotelList = new HashMap<>();
        userList = new HashMap<>();
    }

    // return db instance, if not exist then create one
    public static HotelDatabase getInstanceOfDB(){
        if(instanceOfDB == null){
            instanceOfDB = new HotelDatabase();
        }
        return instanceOfDB;
    }

    // add user to db
    public void addUser(String email, String name){
        if(userList.containsKey(email)){
            System.out.println("User already exist");
            return;
        }
        userList.put(email, name);
        System.out.println("User added succesfully");
    }
    // delete user from db
    public void deleteUser(User user){
        if(userList.containsKey(user.getEmail())){
            userList.remove(user.getEmail());
            System.out.println("User deleted successfully");
        }
        else{
            System.out.println("User does not exist");
        }
    }


    // add hotel to db
    public void addHotel(Hotel hotel){
        if(hotelList.containsKey(hotel.getName())){
            System.out.println("Hotel already exist");
        }
        hotelList.put(hotel.getName(), hotel);
        System.out.println("Hotel added successfully");
    }
    // delete hotel from db
    public void deleteHotel(Hotel hotel){
        if(hotelList.containsKey(hotel.getName())){
            hotelList.remove(hotel.getName());
        }
        else{
            System.out.println("Hotel does not exist");
        }
    }

}
