package Vyuka.basics;

import fileworks.DataExport;
import fileworks.DataImport;

import java.io.IOException;
import java.util.Arrays;

public class ParseFile {
    public static void main(String[] args) throws IOException {
        //import souboru
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);

        /*
              //di.printFile(); //vypis vseho
              System.out.println(di.readLine()); //vypis radku

              //vypis informace jednoho radku
              String name;
              String continent;
              long population;
              double avgAge;

              //vypis vseho, bez printFile
              di.reinitializeRead();
              while (di.hasNext()){
                  System.out.println(di.readLine());
              }

              //nacteni, rozdeleni, parsing a vypis jednoho radku
              String output = di.readLine();
              String [] tokens = output.split(";");

              name = tokens[0];
              continent = tokens[1];
              population = Long.parseLong(tokens[2]);
              avgAge = Double.parseDouble(tokens[3]);

              System.out.println(name);
              System.out.println(continent);
              System.out.println(population);
              System.out.println(avgAge);
         */

        //vypis jednoho radku jako objekt tridy country

        Country czechia = new Country("Czech Republic", "Europa", 10800000L, 85.0);
        System.out.println(czechia);

        //export souboru
        DataExport de = new DataExport("output.txt");



  //     while (di.hasNext()) {
  //         //vypis vsech radku jako objekty tridy country
  //         String line = di.readLine();
  //         String[] tokens = line.split(";");

  //         String name = tokens[0];
  //         String continent = tokens[1];
  //         long population = Long.parseLong(tokens[2]);
  //         double avgAge = Double.parseDouble(tokens[3]);

  //         Country oneCountry = new Country(name, continent, population, avgAge);

  //         if (oneCountry.continent.equals("Europe")){
  //             de.writeLine(oneCountry.toString());
  //         }

  //         System.out.println(oneCountry);
  //     }

        Country bestAge = new Country("TBD", "TBD", 42L, Double.MIN_VALUE);
        Country worstPopulation = new Country("TBD", "TBD", Long.MAX_VALUE, 42);

        while(di.hasNext()){
            String radek = di.readLine();
            String [] casti = radek.split(";");

            String jmeno = casti[0];
            String kontinent = casti[1];
            Long populace = Long.parseLong(casti[2]);
            double prumernyVek = Double.parseDouble(casti[3]);

            //vypis nejvetsi prumerneho veku
            if (bestAge.avgAge < prumernyVek){
                bestAge.name = jmeno;
                bestAge.continent = kontinent;
                bestAge.population = populace;
                bestAge.avgAge = prumernyVek;
            }
            //vypis nejhorsi populace
            if (worstPopulation.avgAge > populace){
                worstPopulation.name = jmeno;
                worstPopulation.continent = kontinent;
                worstPopulation.population = populace;
                worstPopulation.avgAge = prumernyVek;
            }
        }
        System.out.println(bestAge);
        System.out.println(worstPopulation);

        de.finishExport();
        di.finishImport();
    }
}
