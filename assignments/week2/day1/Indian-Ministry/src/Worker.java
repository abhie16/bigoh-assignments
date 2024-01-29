/*
 * MARK :- Worker class
 * DESC :- Worker class implements Person interface and sets the name of worker
 */

public class Worker implements Person {

    private String name;

    public Worker(String name){
        setName(name);
    }

    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
