/*
 * MARK :- Class of Minister
 * DESC :- This is a class for minister which is extending Member of parliament class
 */

public class Minister extends MemberOfParliament {

    private int EXPENSE_LIMIT = 1000000;

    Minister(String name){
        super(name);
    }

    @Override
    public void setConstituency(String constituency) {
        super.setConstituency(constituency);
    }

    @Override
    public void setDriver(String driverName) {
        super.setDriver(driverName);
    }

    /* Method to track and spend money provided to mp */
    public void setSpendMoney(int money){
        super.setSpendMoney(money);
    }

    /* Check if money spend is more then provided money */
    @Override
    public boolean exceedSpendingLimit(){
        return EXPENSE_LIMIT < getSpendMoney() ? true : false;
    }




































    
}
