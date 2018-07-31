package entity;

public class Address {
    private String city;
    private String street;
    private String building;
    private String flat;


    public Address(){

    }


    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }


    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getBuilding() {
        return building;
    }

    public String getFlat() {
        return flat;
    }


    @Override
    public String toString() {
        return "ADDRESS:\n" + "city: " + city + "\nstreet: " + street + "\nbuilding: " + building + "\nflat:  " + flat + "\n";
    }
}
