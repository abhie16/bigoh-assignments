/**
 * MARK :- Admin class
 * DESC :- This admin class have functionality like verifying hotel added by agent, deleting users, deleting hotel.
 */

public class Admin{
    
    // store instance of hotel mangement system
    private HotelManagementSystem system;

    public Admin(){
        system = HotelManagementSystem.getInstance(); // single instance of hotel
    }

    // verify hotel, save all hotel to db which is not verified
    public void verifyHotels(){
        for(Hotel hotel : system.unVerifiedHotel){
            system.addHotelToDB(hotel);
        }
    }

    // delete users from the db
    public void deleteUser(User user){
        system.deleteUser(user);
    }

    // delete hotels
    public void deleteHotel(Hotel hotel){
        system.deleteHotel(hotel);
    }

}
