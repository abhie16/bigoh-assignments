package Message;
public class TextMessage extends Message {
    public TextMessage() {
    }

    @Override
    public void showMessage() {
        System.out.println("This is a text message");
    }
}
