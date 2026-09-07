package vyuka.basics;

import fileworks.DataImport;

public class ParseFile {
    public static void main(String[] args) {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);



        while(di.hasNext()){
            String[] line = di.readLine().split(";");
            Country c = new Country(line[0], line[1], Double.parseDouble(line[2]), Double.parseDouble(line[3]));
            c.printCountry();
            System.out.println(c.toString());
        }






        di.finishImport();
    }
}
