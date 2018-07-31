package entity;

public class PowerMeter {
    private int number;
    private PowerMeterType type;


    public PowerMeter(){

    }


    public void setNumber(int number) {
        this.number = number;
    }

    public void setType(PowerMeterType type) {
        this.type = type;
    }


    public int getNumber() {
        return number;
    }

    public PowerMeterType getType() {
        return type;
    }


    @Override
    public String toString() {
        return "POWER METER:\n" + "number: " + number + "\ntype: " + type + "\n";
    }
}
