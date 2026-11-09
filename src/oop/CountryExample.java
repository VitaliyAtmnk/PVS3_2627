package oop;

import basics.Country;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Comparator;

public class CountryExample {

    static void main() {

        DataImport di = new DataImport("data/countries.txt");

        ArrayList<Country> countries = new ArrayList<>();

        while (di.hasNext()) {

            String line = di.readLine();
            String[] data = line.split(";");

            String name = data[0];
            String continent = data[1];
            long population = Long.parseLong(data[2]);
            double avgAge = Double.parseDouble(data[3]);

            Country country = new Country(name, continent, population, avgAge);

            countries.add(country);
        }

        countries.sort(BY_NAME);

        printList(countries);

        di.finishImport();
    }

    static void printList(ArrayList<Country> countries) {

        for (Country country : countries){

            System.out.println(country.name);
        }
    }

    public static final Comparator<Country> BY_NAME = new Comparator<Country>() {

        @Override
        public int compare(Country country1, Country country2) {

            if (country1.name.length() > country2.name.length()) {

                return 1;
            }

            else if (country1.name.length() < country2.name.length()) {

                return -1;
            }

            else return 0;
        }
    };
}
