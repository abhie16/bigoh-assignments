
public class App {
    public static void main(String[] args) throws Exception {
        Minister minister = new Minister("abhishek");
        Commissioner com = new Commissioner("vivek");

        PrimeMinister pm = new PrimeMinister("ankit");
        
        minister.setSpendMoney(1100000);
        System.out.println(minister.getSpendMoney());
        minister.getVehicle();
        minister.setDriver("pyare mohan");
        System.out.println(minister.getDriver());
        System.out.println(minister.exceedSpendingLimit());
        pm.setPermission(minister);
        com.canArrest(minister);
    }
}
