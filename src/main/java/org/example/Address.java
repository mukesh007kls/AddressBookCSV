package org.example;

public class Address extends Contact {
    private String address;
    private String city;
    private String state;
    private int pinCode;

    public Address(){

    }


    public Address(String firstName, String lastName, long phoneNumber, String eMail, String address, String city, String state, int pinCode) {
        super(firstName, lastName, phoneNumber, eMail);
        this.address = address;
        this.city = city;
        this.state = state;
        this.pinCode = pinCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPinCode() {
        return pinCode;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }
    @Override
    public String toString(){
        return getFirstName()+","+getLastName()+","+getPhoneNumber()+","+getEMail()+","+getAddress()+","+city+","+state+","+pinCode;
    }
}
