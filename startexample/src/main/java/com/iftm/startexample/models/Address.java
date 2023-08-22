package com.iftm.startexample.models;
import java.util.Objects;

public class Address {
    private String street;
    private int number;
    private String country;

    public Address() {
    }

    public Address(String street, int number, String country) {
        this.street = street;
        this.number = number;
        this.country = country;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address street(String street) {
        setStreet(street);
        return this;
    }

    public Address number(int number) {
        setNumber(number);
        return this;
    }

    public Address country(String country) {
        setCountry(country);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Address)) {
            return false;
        }
        Address address = (Address) o;
        return Objects.equals(street, address.street) && number == address.number && Objects.equals(country, address.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, number, country);
    }

    @Override
    public String toString() {
        return "{" +
            " street='" + getStreet() + "'" +
            ", number='" + getNumber() + "'" +
            ", country='" + getCountry() + "'" +
            "}";
    }
    
}
