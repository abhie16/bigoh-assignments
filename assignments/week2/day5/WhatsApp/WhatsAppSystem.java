import java.util.HashMap;

import Message.Message;

public class WhatsAppSystem {

    private static WhatsAppSystem instanceOfWhatsApp = null;

    public HashMap<User, WhatsApp> allContact;

    private WhatsAppSystem(){
        allContact = new HashMap<>();
    }

    public static WhatsAppSystem getInstanceOfWhatsApp(){
        if(instanceOfWhatsApp == null)
            instanceOfWhatsApp = new WhatsAppSystem();
        return instanceOfWhatsApp;
    }

    // add user to central db on based of thier whatsapp
    public void add(User user, WhatsApp whatsApp){
        allContact.put(user, whatsApp);
    }

    // send message from user, to user with message
    public void sendMessage(User from, User to, Message message){
        allContact.get(to).setRecievedMessage(from, message);
    }

    // show status of given user
    public void showStatus(User user){
        allContact.get(user).getStatus().showStatus();
    }
}
