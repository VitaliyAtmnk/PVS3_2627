package vyuka.basics;

import fileworks.DataImport;

import java.io.IOException;

public class ParseFile {
    public static void main(String[] args) throws IOException {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        //        // di.printFile(); // výpis celého souboru
//        // System.out.println(di.readLine()); // výpis jednoho řádku
//
//        // TODO: vypsat celý obsah souboru bez printFile()
//        while (di.hasNext()) {
//            System.out.println(di.readLine());
//        }
//        di.reinitializeRead();
//
//        // TODO: Vypsat informace jednoho řádku
//        String line = di.readLine();
//        String[] tokens = line.split(";");
//
//        String name = tokens[0];
//        String continent = tokens[1];
//        long population = Long.parseLong(tokens[2]);
//        double avgAge = Double.parseDouble(tokens[3]);
//
//        System.out.println(name + "\n" + continent + "\n" + population + "\n" + avgAge);

        Country czechia = new Country("Czech Republic",
                "Europe",
                10_800_000,
                85.0);

        System.out.println(czechia);

        // TODO: Vypsat všechny řádky jako objekty (třídy Country)

        while(di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.split(";");

            String name = tokens[0];
            String continent = tokens[1];
            long population = Long.parseLong(tokens[2]);
            double avgAge = Double.parseDouble(tokens[3]);

            Country oneCountry = new Country(
                    name,
                    continent,
                    population,
                    avgAge
            );
            System.out.println(oneCountry);
        }

        di.finishImport();
    }
}
