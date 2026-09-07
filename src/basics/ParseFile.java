package basics;

import fileworks.DataImport;

import java.io.IOException;

public class ParseFile {
    public static void main(String[] args) throws IOException {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        // di.printFile();
        System.out.println(di.readLine()); // výpis jednoho řádku

        // TODO: Vypsat informace jednoho řádku
        String name;
        String continent;
        long population;
        double avgAge;

        // načíst je z jednoho řádku
        di.readLine();
        di.readLine();
        di.readLine();

        di.hasNext();
        // vypsat celý obsah bez printFile
        di.reinitializeRead();
        int radky;

        while(di.hasNext()){
            System.out.println(di.readLine());
        }


        String line = di.readLine();
        String[] tokens = line.split(";");


        name = tokens[0];
        continent = tokens[1];
        population = Long.parseLong(tokens[2]);
        avgAge = Double.parseDouble(tokens[3]);

        System.out.println(name);
        System.out.println(continent);
        System.out.println(population);
        System.out.println(avgAge);

        di.finishImport();
    }
}
