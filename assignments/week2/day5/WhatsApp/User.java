
public class User {

    private String name;
    
    private WhatsApp whatsApp;

    public User(String name){
        this.name = name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
    public WhatsApp initialiseWhatsApp(){
        whatsApp = new WhatsApp(this);
        return whatsApp;
    }
}
