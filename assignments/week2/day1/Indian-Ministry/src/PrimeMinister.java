
/*
 * MARK :- Class of Prime Minister extending MemeberfoParliament class
 */
public class PrimeMinister extends MemberOfParliament {

    private final int EXPENSE_LIMIT = 10000000;

    public PrimeMinister(String name){
        super(name);
        setVehicle(new AirCraft());
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

    /* set permission to arrest */
    public void setPermission(Minister minister){
        minister.isPermitted = true;
    }
}
