package Message;
public class VoiceMessage extends Message{
    public VoiceMessage() {
    }

    @Override
    public void showMessage() {
        System.out.println("This is a voice message");
    }
}
