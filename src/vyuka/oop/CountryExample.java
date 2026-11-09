package vyuka.oop;

import basics.Country;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Collections;

public class CountryExample {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");

        ArrayList<Country> countries = new ArrayList<>();

        // načíst celý soubor data/countires.txt
        while (di.hasNext()) {
            String line = di.readLine();
            String[] data = line.split(";");

            String name = data[0];
            String continent = data[1];
            long population = Long.parseLong(data[2]);
            double avgAge = Double.parseDouble(data[3]);

            countries.add(new Country(name, population, avgAge));

//            Country country = new Country(
//                    name,
//                    population,
//                    avgAge); // ZDE

//            System.out.println(country);
        }

        Collections.sort(countries);

        for (Country c : countries) {
            System.out.println(c);
        }

        countries.sort(Country.BY_LIFE_LENGTH);
        System.out.println();

        for (Country c : countries){
            System.out.println(c);
        }
        di.finishImport();
    }
}
