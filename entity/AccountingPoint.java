package entity;

public class AccountingPoint {
    private int id;
    private Tenant tenant = new Tenant();
    private PowerMeter powerMeter = new PowerMeter();


    public AccountingPoint(){

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTenant(Tenant tenant) {
        this.tenant = tenant;
    }

    public void setPowerMeter(PowerMeter powerMeter) {
        this.powerMeter = powerMeter;
    }


    public int getId() {
        return id;
    }

    public Tenant getTenant() {
        return tenant;
    }

    public PowerMeter getPowerMeter() {
        return powerMeter;
    }


    @Override
    public String toString() {
        return "ACCOUNTING POINT: \n" + "id: "  + id + "\n" +  tenant.toString() +  powerMeter.toString() + "\n";
    }
}
