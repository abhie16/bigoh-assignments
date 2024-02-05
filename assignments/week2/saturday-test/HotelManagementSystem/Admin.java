/**
 * MARK :- Admin class
 * DESC :- This admin class have functionality like verifying hotel added by agent, deleting users, deleting hotel.
 */

public class Admin extends User{

    public Admin(String name){
        super(name);
    }

    // verify hotel added by agent
    public void verifyHotel(Hotel hotel){
        system.verifyHotels();
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
