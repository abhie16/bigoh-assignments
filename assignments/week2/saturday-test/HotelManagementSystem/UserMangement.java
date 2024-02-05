public class UserMangement {
    private HotelDatabase db;
    
    public UserMangement(){
        db = HotelDatabase.getInstanceOfDB();
    }
   
    public void addUser(String email, String name){
        db.addUser(email, name);
    }
    public void deleteUser(User user){
        db.deleteUser(user);
    }
}
