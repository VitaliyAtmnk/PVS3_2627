package vlastni.oop;
import vlastni.basics.Country;
import fileworks.DataImport;


import java.util.ArrayList;
import java.util.Collections;

public class CountryExample {
    static void printList(ArrayList<Country> items){
        for (Country i : items){
            System.out.println(i);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");
        ArrayList<Country> countries = new ArrayList<>();
        while(di.hasNext()){
            String line = di.readLine();
            String[]tokens = line.split(";");
            String name = tokens[0];
            String continent = tokens[1];
            long population = Long.parseLong(tokens[2]);
            double avgAge = Double.parseDouble(tokens[3]);
            countries.add(new Country(name, continent,population,avgAge));
        }

        Collections.sort(countries);
        printList(countries);

        Collections.sort(countries, Country.BY_AVG_AGE);
        printList(countries);


        Collections.sort(countries.reversed(), Country.BY_AVG_AGE);
        printList(countries);

    }
}
