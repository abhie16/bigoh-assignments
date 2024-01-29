/*
 * MARK :- company class
 * DESC :- this company class is used to make invertors and show its info
 */

import java.util.HashMap;

public class Company {
    private HashMap<String, Invertor> invertorInfo;

    public Company(){
        invertorInfo = new HashMap<>();
    }

    /* add inventor to the company list */
    public void addInvertor(Invertor invertor){
        invertorInfo.put(invertor.getName(), invertor);
    }

    /* Show invertors present in company */
    public void showInvertor(){
        for(String key : invertorInfo.keySet()){
            System.out.println(invertorInfo.get(key).getName());
        }
    }

    /* show info of given invertor */
    public void invertorInfo(String invertorName){
        Invertor invertor = invertorInfo.get(invertorName);

        System.out.println("Name: "+invertor.getName());
        System.out.println("Battery Avaiable: "+ invertor.getBatteryAvailability());
    }
}
