package model;

import com.github.javafaker.Faker;

public class CheckOutModel {
    private String name;
    private String country;
    private String city;
    private String creditCart;
    private String month;
    private String year;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCreditCart() {
        return creditCart;
    }

    public void setCreditCart(String creditCart) {
        this.creditCart = creditCart;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


}
