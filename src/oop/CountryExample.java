package oop;

import basics.Country;
import fileworks.DataImport;

public class CountryExample {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");

        // načíst celý soubor data/countires.txt
        while (di.hasNext()) {
            String line = di.readLine();
            String[] data = line.split(";");

            String name = data[0];
            String continent = data[1];
            long population = Long.parseLong(data[2]);
            double avgAge = Double.parseDouble(data[3]);

            Country country = new Country(
                    name,
                    population,
                    avgAge); // ZDE

            System.out.println(country);
        }

        di.finishImport();
    }
}
