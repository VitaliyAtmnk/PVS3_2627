package Vyuka.OOP;

import Vyuka.basics.Country;
import fileworks.DataImport;
import java.util.ArrayList;


public class CountryExample{

    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");
        ArrayList<Country> countries = new ArrayList<>();

        while (di.hasNext()){
            String line = di.readLine();
            String [] data = line.split(";");

            String name = data[0];
            String continent = data[1];
            long population = Long.parseLong(data[2]);
            double avgAge = Double.parseDouble(data[3]);

            Country country = new Country(name, continent, population, avgAge);

            countries.add(country);
        }
        System.out.println(countries);
        countries.sort(Country.BY_AVG_AGE);
        System.out.println(countries);

        di.finishImport();
    }
}
