package com.srbh6092gl.resort;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EventManager {
    static List<Guest> guests = new ArrayList<>();

    public static void main(String[] args) {
        populateGuests();
        guests.forEach(System.out::println);
        filterGuests();
    }
    private static void populateGuests() {
        guests.add(new Guest("A",Country.USA,Hobby.DRINK,Language.ENGLISH, LocalDate.of(1999, Month.JANUARY,01)));
        guests.add(new Guest("B",Country.SPAIN,Hobby.EAT,Language.SPANISH, LocalDate.of(1998, Month.JULY,15)));
        guests.add(new Guest("C",Country.GERMANY,Hobby.MUSIC,Language.GERMAN, LocalDate.of(2000, Month.FEBRUARY,23)));
        guests.add(new Guest("D",Country.FRANCE,Hobby.WATERSPORT,Language.FRENCH, LocalDate.of(1999, Month.AUGUST,10)));
        guests.add(new Guest("E",Country.SPAIN,Hobby.TRAVEL,Language.SPANISH, LocalDate.of(2001, Month.JANUARY,05)));
        guests.add(new Guest("F",Country.CHINA,Hobby.WATERSPORT,Language.CHINESE, LocalDate.of(2000, Month.SEPTEMBER,17)));
        guests.add(new Guest("G",Country.SPAIN,Hobby.DANCE,Language.SPANISH, LocalDate.of(2008, Month.JULY,15)));
        guests.add(new Guest("H",Country.SPAIN,Hobby.DRINK,Language.SPANISH, LocalDate.of(2008, Month.JULY,15)));
        guests.add(new Guest("I",Country.SPAIN,Hobby.DRINK,Language.SPANISH, LocalDate.of(1947, Month.JULY,15)));
        guests.add(new Guest("D",Country.FRANCE,Hobby.MUSIC,Language.FRENCH, LocalDate.of(1999, Month.AUGUST,10)));
    }

    private static void filterGuests() {
        Predicate<Guest> fromSpain = guest -> guest.getCountry() == Country.SPAIN;
        Predicate<Guest> loveMusicAndDance = guest -> guest.getHobby() == Hobby.MUSIC || guest.getHobby() == Hobby.DANCE;
        Predicate<Guest> loveDrinkAndAbove18 = guest -> guest.getHobby() == Hobby.DRINK && Period.between(guest.getDate(),LocalDate.now()).getYears()>=18;
        Predicate<Guest> loveSports = guest -> guest.getHobby() == Hobby.WATERSPORT;
        Predicate<Guest> fromFrance = guest -> guest.getCountry() == Country.FRANCE;
        Predicate<Guest> above70 = guest -> Period.between(guest.getDate(),LocalDate.now()).getYears()>=70;
        Predicate<Guest> speakChineseAndRead = guest -> guest.getLanguage() == Language.CHINESE && guest.getHobby()==Hobby.READ;

        System.out.println("*********************************");
        System.out.println("From Spain, Loves Music or Dance");
        guests.stream().filter(fromSpain).filter(loveMusicAndDance).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("*********************************");
        System.out.println("From Spain, Loves Drink and is above 18");
        guests.stream().filter(fromSpain).filter(loveDrinkAndAbove18).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("*********************************");
        System.out.println("From France, Loves Sports");
        guests.stream().filter(fromFrance).filter(loveSports).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("*********************************");
        System.out.print("Above 70 count: ");
        System.out.println((int) guests.stream().filter(above70).count());;
        System.out.println("*********************************");
        System.out.println("Speak Chinese and read");
        guests.stream().filter(speakChineseAndRead).collect(Collectors.toList()).forEach(System.out::println);


    }

}
