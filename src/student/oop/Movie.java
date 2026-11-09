package student.oop;

import basics.Country;
import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

public class Movie {
    String name;
    int yearOf;
    String zaner;
    double rating;

    public Movie(String name, int yearOf, String zaner, double rating) {
        this.name = name;
        this.yearOf = yearOf;
        this.zaner = zaner;
        this.rating = rating;
    }


    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", yearOf=" + yearOf +
                ", zaner='" + zaner + '\'' +
                ", rating=" + rating +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getYearOf() {
        return yearOf;
    }

    public String getZaner() {
        return zaner;
    }

    public double getRating() {
        return rating;
    }


    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setZaner(String zaner) {
        this.zaner = zaner;
    }

    public void setYearOf(int yearOf) {
        this.yearOf = yearOf;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/movieList.txt");

        int pocetFilm = 0;
        while (di.hasNext()) {
            String all = di.readLine();
            String[] split =  all.split(";");
            Movie movie = new Movie(split[0],
                    Integer.parseInt(split[1]),
                    split[2],
                    Double.parseDouble(split[3]));
            if (movie.yearOf == 2000) {pocetFilm++;}
        }
        System.out.println("v 2000 vyšlo: " + pocetFilm + "filmů");

        Movie bestRating = new Movie("TBD", 0, "nic", Double.MIN_VALUE);
        while (di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.split(";");

            String name = tokens[0];
            int yearOf = Integer.parseInt(tokens[1]);
            String zaner = (tokens[2]);
            double rating = Double.parseDouble(tokens[3]);

            if (bestRating.rating < rating) {
                bestRating.name = name;
                bestRating.yearOf = yearOf;
                bestRating.zaner = zaner;
                bestRating.rating = rating;
            }
        }
        System.out.println(bestRating.toString());

        DataExport mi = new DataExport("horrors.txt");
        while (di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.split(";");
            Movie nic = new Movie(tokens[0],
            Integer.parseInt(tokens[1]),
            (tokens[2]),
            Double.parseDouble(tokens[3]));

          if (nic.zaner.equals("Horror")){
              mi.writeLine(nic.toString());

          }
        }


        di.finishImport();
        mi.finishExport();
    }

}
