package tests;

import fileworks.DataExport;
import fileworks.DataImport;

public class Movie {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/movieList.txt");
        DataExport de = new DataExport("horrors.txt");

        double bestRating = Long.MIN_VALUE;
        String nameOfBestMovie = "";
        int numOfMoviesAfterYear = 0;

        while(di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.split(";");

            String name = tokens[0];
            String type = tokens[2];
            int year = Integer.parseInt(tokens[1]);
            double rating = Double.parseDouble(tokens[3]);

            if(rating > bestRating) {
                bestRating = rating;
                nameOfBestMovie = name;
            }

            if(year > 2000) numOfMoviesAfterYear++;

            if(type.equals("Horror")) de.writeLine(line);
        }

        System.out.println("Best rated movie: " + nameOfBestMovie + " with rating of: " + bestRating);
        System.out.println("Number of movies that released after the year 2000: " + numOfMoviesAfterYear);

        di.finishImport();
        de.finishExport();
    }
}
