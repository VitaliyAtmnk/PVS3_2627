package student.oop.interfaces;

import student.basics.Country;

public class Country_interface extends Country {
    public Country_interface(String name, String continent, long population, double avarigeAge) {
        super(name, continent, population, avarigeAge);
    }
}

//Interfaci řeším v classce Country ve složce basics


public static void main(String[] args) {
    Country_interface c1 = new Country_interface(Germany, Europe, 45000, 15);
}