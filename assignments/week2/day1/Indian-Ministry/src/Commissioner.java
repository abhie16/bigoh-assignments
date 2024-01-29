/*
 * MARK :- Class of comissioner
 * DESC :- This comissioner class has method to arrest mps and ministers
 */

public class Commissioner implements Person {

    private String name;

    /* Constructor */
    public Commissioner(String name){
        setName(name);
    }

    /* Implement getter and setter of person interface */
    @Override
    public void setName(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


    /* Arrest if we can arrest them, else take permission */
    public void canArrest(MemberOfParliament mp){

        // check if limit is exceeded
        if(mp.exceedSpendingLimit()){
            System.out.println("Arrested");
        }
        else{
            System.out.println("cant arrest, not exceeding spending limit");
        }
    }

    public void canArrest(Minister minister){

        // check if limit is exceeded
        if(minister.exceedSpendingLimit()){
            // check for permission from PM
            if(minister.isPermitted) System.out.println("Arrested");
            else System.out.println("permission needed");
        }
        else{
            System.out.println("cant arrest, not exceeding spending limit");
        }
    }

    /* PM cannot be arrested by commissioner */
    public void canArrest(PrimeMinister pm){
        System.out.println("Cant arrest PM");
    }
}
