package basics;

import fileworks.DataExport;
import fileworks.DataImport;


public class ParseFile {
    public static void main(String[] args) {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        // di.printFile();
//        System.out.println(di.readLine()); // výpis jednoho řádku
//
//        // TODO: Vypsat informace jednoho řádku
//        String name;
//        String continent;
//        long population;
//        double avgAge;
//
//        // načíst je z jednoho řádku
//        di.readLine();
//        di.readLine();
//        di.readLine();
//
//
//        di.reinitializeRead();
//        // vypsat celý obsah bez printFile
//
//        String line = "";
//        while(di.hasNext()){
//            line = di.readLine();
//        }
//
//        // String line = di.readLine();
//
//        String[] tokens = line.split(";");
//
//        name = tokens[0];
//        continent = tokens[1];
//        population = Long.parseLong(tokens[2]);
//        avgAge = Double.parseDouble(tokens[3]);
//
//        System.out.println(name);
//        System.out.println(continent);
//        System.out.println(population);
//        System.out.println(avgAge);
        Country czechia = new Country("Czech Republic",
                "Europe",
                10_800_000,
                85.0);

        System.out.println(czechia);
        DataExport de = new DataExport("output.txt");


        Country bestAge = new Country("TBD", "TBD", 42, Double.MIN_VALUE);
        Country worstPopulation = new Country("TBD", "TBD", Long.MAX_VALUE, 42);

        // Vypsat všechny řádky jako objekty (třídy Country)
        // 1. přečíst soubor
        //  1.1 přečíst řádek
        // 2. Do konzole vypsat:
        // zeme s nejvetsim avgAge
        // zeme s nejmensi populaci

        while (di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.split(";");

            String name = tokens[0];
            String continent = tokens[1];
            long population = Long.parseLong(tokens[2]);
            double averageAge = Double.parseDouble(tokens[3]);

            if(bestAge.avgAge < averageAge) {
                bestAge.name = name;
                bestAge.continent = continent;
                bestAge.population = population;
                bestAge.avgAge = averageAge;
            }

            if(worstPopulation.population > population){
                worstPopulation.name = name;
                worstPopulation.continent = continent;
                worstPopulation.population = population;
                worstPopulation.avgAge = averageAge;
            }

           /* String line = di.readLine(); // načíst řádek
            String[] tokens = line.split(";"); // rozsekat řádek

            // parsing
            String name = tokens[0];
            String continent = tokens[1];
            long population = Long.parseLong(tokens[2]);
            double avgAge = Double.parseDouble(tokens[3]);

            // vytvoření objektu
            Country oneCountry = new Country(
                    name,
                    continent,
                    population,
                    avgAge
            );

            if (oneCountry.continent.equals("Europe")){
                de.writeLine(oneCountry.toString());
            }
            if (oneCountry.avgAge > bestAge.avgAge){
                bestAge = oneCountry;
            }

            if (oneCountry.population < worstPopulation.population){
                worstPopulation = oneCountry;
            }

            System.out.println(oneCountry);*/
        }

        //export
        de.finishExport();

        System.out.println("------");
        System.out.println("Nejhorsi populace: " + worstPopulation);
        System.out.println("Nejlepsi doba doziti: " + bestAge);
        di.finishImport();
    }
}
