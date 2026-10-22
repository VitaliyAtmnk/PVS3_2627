package Vyuka.OOP;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

public class Movie {

    String name;
    int year;
    String genre;
    double rating;

    public Movie(String name, int year, String genre, double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public String getGenre() {
        return genre;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }


    public static void main(String[] args) {
        DataImport di = new DataImport("data/movieList.txt");

        List<Movie> movies = new ArrayList<>();
        Movie bestRating = new Movie("TBD", 0, "TBD", Double.MIN_VALUE);

        while (di.hasNext()){
            String line = di.readLine();
            String[]tokens = line.split(";");

            Movie film = new Movie(
                    tokens[0],
                    Integer.parseInt(tokens[1]),
                    tokens[2],
                    Double.parseDouble(tokens[3])
                    );
            movies.add(film);

            if (film.rating > (bestRating.rating)){
                bestRating = film;
            }
        }
        System.out.println(bestRating);

        int count2000 = 0;
        for (Movie film : movies){
            if (film.getYear() > 2000){
                count2000++;
            }
        }
        System.out.println(count2000);

        DataExport de = new DataExport("horrors.txt");

        for (Movie film : movies){
            if (film.getGenre().equalsIgnoreCase("Horror")){
                de.writeLine(film.toString());
            }
        }


        di.finishImport();
        de.finishExport();


    }
}