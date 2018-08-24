package entity;

public class PowerMeter {
    private int number;

    public PowerMeter(){

    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "POWER METER:\n" + "number: " + number + "\n";
    }
}
