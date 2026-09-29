package exams;

import fileworks.DataExport;
import fileworks.DataImport;

import java.util.ArrayList;

class Movie{
    String name;
    int year;
    String genre;
    double rating;

    // alt + insert
    public Movie(String name, int year, String genre, double rating) {
        this.name = name;
        this.year = year;
        this.genre = genre;
        this.rating = rating;
    }

    /**
     * Tady tohle bude defaultni stringovy vystup z volani metody
     * @return Stringovou reprezantaci filmu
     */
    @Override
    public String toString() {
        return "Movie{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre='" + genre + '\'' +
                ", rating=" + rating +
                '}';
    }
}


public class MovieExampleSolution {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/movieList.txt");
        DataExport de = new DataExport("horrors.txt");

        Movie bestFilm = new Movie(null, 0, null, Double.MIN_VALUE);
        ArrayList<Movie> movies = new ArrayList<>();
        int postMilenium = 0;
        int numberOfHorros = 0;
        // 1. vypsat nejlepší film dle hodnocení
        while(di.hasNext()){
            String line = di.readLine();
            String[] data = line.split(";");

            Movie movie = new Movie(
                    data[0],
                    Integer.parseInt(data[1]),
                    data[2],
                    Double.parseDouble(data[3])
            );

            if(movie.rating > bestFilm.rating){
                bestFilm = movie;
            }
            // 3. vypsat horrory
            if(movie.genre.equalsIgnoreCase("horror")){
                numberOfHorros++;
                de.writeLine(movie.toString());
            }

            // 2. spočítat filmy po roce 2000
            if(movie.year >= 2000){
                postMilenium++;
            }

            movies.add(movie);
        }
//
//        int post2015 = 0;
//        for (Movie m : movies){
//            System.out.println(m);
//            if(m.year == 2015) post2015++;
//        }

        System.out.println("The best movie of all time is: " + bestFilm);
        System.out.println("Number of films postmilenium is: " + postMilenium);
        System.out.println("Number of horrors: " + numberOfHorros);
        System.out.println("Total: " + movies.size());

        di.finishImport();
        de.finishExport();

    }
}
