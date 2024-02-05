/**
 * MARK :- Hotel agent class
 * DESC :- Inheriting user class with additional options like add hotel and update hotel information
 */

public class HotelAgent extends User {

    // constructor to set name;
    public HotelAgent(String name){
        super(name);
    }

    // add hotel
    public void addHotel(Hotel hotel){
        system.addHotel(hotel);
    }

    // update hotel
    public void updateHotel(Hotel hotel){
        system.updateHotel(hotel);
    }

}
