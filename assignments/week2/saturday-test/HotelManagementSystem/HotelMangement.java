import java.util.ArrayList;

public class HotelMangement {

    // store hotel added by agent
    public ArrayList<Hotel> unVerifiedHotel;
    private HotelDatabase db;

    public HotelMangement() {
        unVerifiedHotel = new ArrayList<>();
        db = HotelDatabase.getInstanceOfDB(); // get instance of db
    }

    // add hotel for agent
    public void addHotel(Hotel hotel) {
        unVerifiedHotel.add(hotel);
    }

    public void deleteHotel(Hotel hotel) {
        db.deleteHotel(hotel);
    }


    // book hotel of given name , location and number of rooms to book
    public Hotel bookHotel(String nameOfHotel, String locationOfHotel, int rooms) {
        return db.bookHotel(nameOfHotel, locationOfHotel, rooms);
    }

    // verify hotel, save all hotel to db which is not verified
    public void verifyHotels() {
        for (Hotel hotel : unVerifiedHotel) {
            db.addHotel(hotel);
        }
    }
}
