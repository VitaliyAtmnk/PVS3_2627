package student.oop;
import fileworks.DataImport;
import student.basics.Country;

import javax.xml.crypto.Data;


public class CountryExample {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/countries.txt");

        while (di.hasNext()){
            String Line = di.readLine();
            String[] split =  Line.split(";");
            Country n = new Country(split[0], split[1], Long.parseLong(split[2]), Double.parseDouble(split[3]));
        }
    }
}
