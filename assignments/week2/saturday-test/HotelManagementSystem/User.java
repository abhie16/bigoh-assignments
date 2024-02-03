import java.util.Scanner;

/**
 * MARK :- User class
 * DESC :- This is a user class with option like register, search hotels, book hotels and can update their details
 *          Characteristics of user :- NAME and EMAIL
 */

public class User {

    Scanner scn;

    private String name;
    private String email;

    // store instance of hotel mangement system
    private HotelManagementSystem system;

    public User(String name){
        scn = new Scanner(System.in);
        this.name = name;
        system = HotelManagementSystem.getInstance(); // single instance
    }

    // get email of user
    public String getEmail(){
        return email;
    }

    // register
    public void register(String email){
        this.email = email;
        system.addUser(email, name);
    }

    // search hotel on basis of name and location
    public void searchHotels(){   
        System.out.println("Enter name of hotel to search: ");
        String nameOfHotel = scn.next();
        System.out.println("Enter location of hotel to search: ");
        String locationOfHotel = scn.next();

        system.search(nameOfHotel, locationOfHotel);
    }

    // bookHotel
    public Hotel bookHotel(){
        System.out.println("Enter name of hotel to book: ");
        String nameOfHotel = scn.next();
        System.out.println("Enter location of hotel to book: ");
        String locationOfHotel = scn.next();
        System.out.println("Enter number of rooms to book: ");
        int rooms = scn.nextInt();

        return system.bookHotel(nameOfHotel, locationOfHotel, rooms);
    }

    // updateDetails of user
    public void updateDetails(String name, String email){
        this.name = name;
        this.email = email;
        register(email);
    }

    // give feedback of the hotel
    public void giveFeedback(Hotel hotel){
        System.out.println("Please given feedback for hotel: "+hotel.getName());
        System.out.println("Enter number of rating you want to give: ");
        System.out.println("1. very bad");
        System.out.println("2. bad");
        System.out.println("3. average");
        System.out.println("4. good");
        System.out.println("5. awesome");

        int rating = scn.nextInt();
        
        if(rating > 0 && rating <=5){
            System.out.println("Thank You");
            hotel.setRating(rating);
        }  
        else{
            System.out.println("please enter 1 to 5 rating");
        }

    }
    
}
