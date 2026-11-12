package exams;
//Doplnte atributy pro Film
//
//Jsou jimi:
//Název filmu,
//Rok vydani,
//rating (4.5, 7.8... vyssi = lepsi)
//doba trvani ve vterinach
//
//Vypis do konzole:
//Vypsano serazene dle data vydani od nejstarsich
//Vypsano serazeno dle jmena
//TOP 10 filmu dle ratingu

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

//Link na odevzdani GIST:
//https://forms.cloud.microsoft/Pages/ResponsePage.aspx?id=f_BDFfkwekCetYp67EGP_1pSNPXTVBFPg7PGychWGEdUM040WFhKVFpJQ1RBUVZYVUU2MUYxS0hETCQlQCNjPTEu
public class MovieComparing {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/Movies.txt");
        ArrayList<Movie> movies = new ArrayList<>();

        while(di.hasNext()) {
            String line = di.readLine();
            String[] params = line.split(";");
            movies.add(new Movie(params[0],
                    Integer.parseInt(params[1]),
                    Double.parseDouble(params[2]),
                    Integer.parseInt(params[3])));
        }

        movies.sort(Movie.BY_CREATION_DATE);

        for (Movie m : movies) {
            System.out.println(m.name + " " + m.year + " " + m.rating + " " + m.lengthSec);
        }

        System.out.println("\n\n");
        Collections.sort(movies);

        for (Movie m : movies) {
            System.out.println(m.name + " " + m.year + " " + m.rating + " " + m.lengthSec);
        }

        movies.sort(Movie.BY_RATING.reversed());
        System.out.println("\n\n");

        for (Movie m : movies) {
            System.out.println(m.name + " " + m.year + " " + m.rating + " " + m.lengthSec);
        }

        di.finishImport();
    }
}
class Movie implements Comparable<Movie>{
    String name;
    int year;
    double rating;
    int lengthSec;

    public Movie(String name, int year, double rating, int lengthSec) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        this.lengthSec = lengthSec;
    }

    public static final Comparator<Movie> BY_CREATION_DATE = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Integer.compare(o1.year, o2.year);
        }
    };

    public static final Comparator<Movie> BY_RATING = new Comparator<Movie>() {
        @Override
        public int compare(Movie o1, Movie o2) {
            return Double.compare(o1.rating, o2.rating);
        }
    };

    @Override
    public int compareTo(Movie o) {
        Integer length1 = name.length();
        int length2 = o.name.length();
        return length1.compareTo(length2);
    }
}