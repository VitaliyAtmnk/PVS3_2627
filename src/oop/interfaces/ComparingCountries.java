package oop.interfaces;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparingCountries {

    static ArrayList<Country> loadData(String path){
        DataImport di = new DataImport(path);
        ArrayList<Country> countries = new ArrayList<>();
        String line;
        String[] params;
        while (di.hasNext()){
            line = di.readLine();
            params = line.split(";");
            countries.add(new Country(
               params[0],
               params[1],
               Long.parseLong(params[2]),
               Double.parseDouble(params[3])
            ));
        }
        di.finishImport();

        return countries;
    }

   static void printList(ArrayList<Country> countries){
       System.out.println("Countries:");
       for (Country c : countries){
           System.out.println(c);
       }
       System.out.println();
       System.out.println("-------");
       System.out.println();
   }

    public static void main(String[] args) {
        ArrayList<Country> countries = loadData("data/countries.txt");
        Collections.shuffle(countries);
        printList(countries);

        //podle populace:
        countries.sort(Country.BY_POPULATION);
        printList(countries);

        //podle veku - od nejvyssich:
        countries.sort(Country.BY_AVG_AGE.reversed());
        printList(countries);
    }

}
class Country implements Comparable<Country>{
    String name, continent;
    long population;
    double avgAge;


    public static final Comparator<Country> BY_CONTINENT = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return o1.continent.compareTo(o2.continent);
        }
    };

    public static final Comparator<Country> BY_POPULATION = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return Long.compare(o1.population, o2.population);
        }
    };

    public static final Comparator<Country> BY_AVG_AGE = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return Double.compare(o1.avgAge, o2.avgAge);
        }
    };

    public Country(String name, String continent, long population, double avgAge) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.avgAge = avgAge;
    }


    @Override
    public int compareTo(Country o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return name + " (" + continent + "); Populated: " + population + " ( average age: " + avgAge + ")";
    }
}
