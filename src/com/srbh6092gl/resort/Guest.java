package com.srbh6092gl.resort;

import java.time.LocalDate;

public class Guest {
    String name;
    Country country;
    Hobby hobby;
    Language language;
    LocalDate date;

    public Guest(String name, Country country, Hobby hobby, Language language, LocalDate date) {
        this.name = name;
        this.country = country;
        this.hobby = hobby;
        this.language = language;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Hobby getHobby() {
        return hobby;
    }

    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", country=" + country +
                ", hobby=" + hobby +
                ", language=" + language +
                ", date=" + date +
                '}';
    }
}
