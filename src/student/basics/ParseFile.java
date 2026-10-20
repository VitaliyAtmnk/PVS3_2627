package student.basics;

import fileworks.DataImport;

import java.io.IOException;

public class ParseFile {
    public static void main(String[] args) throws IOException {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        di.printFile();
        di.readChar();
        System.out.println(di.readLine()); // výis jednoho řádku

        String name;
        String continent;
        long population;
        double avarigeAge;




        di.reinitializeRead();

        while (di.hasNext()) {
            String all = di.readLine();
            String[] split =  all.split(";");
            Country n = new Country(split[0], split[1], Long.parseLong(split[2]), Double.parseDouble(split[3]));
            System.out.println(n);
        }

        di.finishImport();
    }
}
