package Vyuka.OOP;

import basics.Country;
import fileworks.DataImport;

import java.awt.geom.CubicCurve2D;

public class CountryExample {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");

        while (di.hasNext()){
            String line = di.readLine();
            String [] data = line.split(";");

            String name = data[0];
            String continent = data[1];
            long population = Long.parseLong(data[2]);
            double avgAge = Double.parseDouble(data[3]);

            Country country = new Country(name, continent, population, avgAge);

            System.out.println(country);
        }
        di.finishImport();
    }
}
