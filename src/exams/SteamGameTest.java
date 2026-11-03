package exams;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

// Soubor má 4 sloupečky oddělené znakem "\t" - tabulátor
// name	price	num_reviews_total	short_description
// Některé řádky nemusí obsahovat krátký popisek

// Naimplementujte třídu reprezentující 1 hru/řádek
// Načtěte soubor
// Naimplementujte jednotlivé metody

public class SteamGameTest {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/steam_games.txt");

        List<Game> games = new ArrayList<>();

        while(di.hasNext()){
            String line = di.readLine();
            String [] tokens = line.split("\t");

            if (tokens.length == 3){
                Game hra = new Game(tokens[0],
                        Double.parseDouble(tokens[1]),
                        Long.parseLong(tokens[2]));
                games.add(hra);
            }

            if (tokens.length == 4){
                Game hra = new Game(tokens[0],
                        Double.parseDouble(tokens[1]),
                        Long.parseLong(tokens[2]),
                        tokens[3]);
                games.add(hra);
            }
        }

     System.out.println("Games total loaded: " + games.size());

        System.out.println("Number of free games: " + totalFreeGames(games));
        System.out.println("Average number of reviews per game: " + avgReviewPerGame(games));
        System.out.println("The most expensive game is: " + mostExpansive(games));

        System.out.println(games.get(0));                   // zdarma
        System.out.println(games.get(games.size() / 2));// placené

        di.finishImport();
    }

    private static Game mostExpansive(List<Game> games) {

        Game biggestPrice = new Game("", Double.MIN_VALUE, 0, "");
        for (Game hra : games){
            if (hra.price > (biggestPrice.price)){
                biggestPrice = hra;
            }
        }
        return biggestPrice;
    }

    private static long totalFreeGames(List<Game> games) {
        int pocetFree = 0;
        for (Game hra : games){
            if (hra.price == 0.0){
                pocetFree++;
            }
        }
        return pocetFree;
    }
    private static double avgReviewPerGame(List<Game> games) {

        long totalRevCOUNT = 0;
        long totalRevAVG = 0;
        for (Game hra : games){
            totalRevCOUNT += hra.getTotalReviews();

        }

        return totalRevAVG = totalRevCOUNT/games.size();
    }
}

class Game {

    String name;
    double price;
    long totalReviews;
    String shortDescription;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getTotalReviews() {
        return totalReviews;
    }

    public void setTotalReviews(long totalReviews) {
        this.totalReviews = totalReviews;
    }

    public String getShortDescription() {
        if (this.shortDescription == null && price == 0.0){
            return shortDescription = "Not released yet";
        }
        else {
            return this.shortDescription;
        }
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public Game(String name, double price, long totalReviews, String shortDescription) {
        this(name, price, totalReviews);
        this.shortDescription = shortDescription;
    }

    public Game(String name, double price, long totalReviews) {
        this.name = name;
        this.price = price;
        this.totalReviews = totalReviews;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", totalReviews=" + totalReviews +
                ", shortDescription='" + getShortDescription() + '\'' +
                '}';
    }
}