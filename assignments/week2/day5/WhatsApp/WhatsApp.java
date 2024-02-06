import java.util.HashMap;

import Message.Message;
import Status.Status;

public class WhatsApp {

    private WhatsAppSystem system;
    private User currUser;
    private Status status;
    private HashMap<User, Message> recievedMessage;

    public WhatsApp(User currUser){
        recievedMessage = new HashMap<>();
        this.currUser = currUser;
        system = WhatsAppSystem.getInstanceOfWhatsApp();
    }

    // getter and setter of status of current user
    public void setStatus(Status status){
        this.status = status;
    }
    public Status getStatus(){
        return status;
    }

    public void sendMessage(User user, Message message){
        system.sendMessage(currUser, user, message);
    }

    public void addContact(User user){
        system.add(user, this);
    }

    public void seeStatus(User user){
        system.showStatus(user);
    }

    public void setRecievedMessage(User from, Message message){
        recievedMessage.put(from, message);
    }

    public void showRecievedMessage(){
        for(User user : recievedMessage.keySet()){
            recievedMessage.get(user).showMessage();
        }
    }
}
