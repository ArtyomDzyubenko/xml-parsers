package entity;

public class Tenant {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private int account;
    Address address = new Address();


    public Tenant(){

    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAccount(int account) {
        this.account = account;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public int getAccount() {
        return account;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "TENANT:\n" + "First name: " + firstName + "\nLast name: " + lastName + "\nPhone number: " + phoneNumber +
                "\nEmail: " + email + "\ncity: " + address.getCity() + "\nstreet: " + address.getStreet() +
                "\nbuilding: " + address.getBuilding() + "\nflat: " + address.getFlat() + "\n";
    }
}
