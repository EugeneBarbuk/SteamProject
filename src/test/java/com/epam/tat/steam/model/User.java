package com.epam.tat.steam.model;

import java.util.Objects;
import java.util.StringJoiner;

public class User {
    private String profileName;
    private String name;
    private String country;
    private String city;

    public User(String profileName, String name, String country, String city) {
        this.profileName = profileName;
        this.name = name;
        this.country = country;
        this.city = city;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getProfileName().equals(user.getProfileName()) &&
                Objects.equals(getName(), user.getName()) &&
                Objects.equals(getCountry(), user.getCountry()) &&
                Objects.equals(getCity(), user.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProfileName(), getName(), getCountry(), getCity());
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("profileName='" + profileName + "'")
                .add("name='" + name + "'")
                .add("country='" + country + "'")
                .add("city='" + city + "'")
                .toString();
    }
}
