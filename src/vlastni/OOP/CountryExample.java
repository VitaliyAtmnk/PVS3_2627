package vlastni.OOP;
import vlastni.basics.Country;
import fileworks.DataImport;

public class CountryExample {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");
        while(di.hasNext()){
            String line = di.readLine();
            String[]tokens = line.split(";");
            String name = tokens[0];
            String continent = tokens[1];
            long population = Long.parseLong(tokens[2]);
            double avgAge = Double.parseDouble(tokens[3]);
            Country oneCountry = new Country(name, continent,population,avgAge);
        }
    }
}
