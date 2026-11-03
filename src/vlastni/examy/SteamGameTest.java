package vlastni.examy;

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
            String[] tokens = line.split("\t");
            switch (tokens.length){
                case 4:
                    games.add(new Game(tokens[0],Double.parseDouble(tokens[1]),Integer.parseInt(tokens[2]),tokens[3]));
                    break;
                case 3:
                    games.add(new Game(tokens[0],Double.parseDouble(tokens[1]),Integer.parseInt(tokens[2])));
            }

        }

        System.out.println("Games total loaded: " + games.size());
        System.out.println("Number of free games: " + totalFreeGames(games));
        System.out.println("Average number of reviews per game: " + avgReviewPerGame(games));
        System.out.println("The most expensive game is: " + mostExpansive(games));
        System.out.println("The free game with the most reviews: " + bestFreeGame(games));

    }

    private static Game mostExpansive(List<Game> games) {
        Game mostExpensive = new Game(null,Double.MIN_VALUE,69420,null);
        mostExpensive = games.getFirst();

        for (Game currentGame : games){
            if (currentGame.getPrice() > mostExpensive.getPrice()) {
                mostExpensive = currentGame;
            }
        }
        return mostExpensive;
    }

    private static long totalFreeGames(List<Game> games) {
        long freeGames = 0;
        for (Game currentGame : games){
            if (currentGame.isFree){
                freeGames++;
            }
        }
        return freeGames;
    }
    private static double avgReviewPerGame(List<Game> games) {
        double sumOfReviews = 0.0;
        for (Game currentGame: games){
            sumOfReviews += currentGame.num_reviews_total;
        }

        return sumOfReviews/games.size();
    }
    private static Game bestFreeGame(List<Game> games){
        Game bestFreeGame = games.getFirst();
        for (Game currentGame : games){
            if (currentGame.isFree && currentGame.getNum_reviews_total() > bestFreeGame.num_reviews_total ){
                bestFreeGame = currentGame;
            }
        }
        return bestFreeGame;
    }
}

class Game {
    String name;
    double price;
    int num_reviews_total;
    String short_description;
    boolean isFree = false;

    public Game(String name, double price, int num_reviews_total, String short_description) {
        this.name = name;
        this.price = price;
        this.num_reviews_total = num_reviews_total;
        this.short_description = short_description;
        if (this.price == 0.00){
            isFree = true;
        }
    }

    public Game(String name, double price, int num_reviews_total) {
        this.name = name;
        this.price = price;
        this.num_reviews_total = num_reviews_total;
        if (this.price == 0.00){
            isFree = true;
        }


    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNum_reviews_total(int num_reviews_total) {
        this.num_reviews_total = num_reviews_total;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;

    }

    public String getName() {
        return name;
    }

    public double getPrice() {

        return price;
    }

    public int getNum_reviews_total() {
        return num_reviews_total;
    }

    public String getShort_description()
    {
        if (this.isFree && this.short_description.isEmpty()){
            return "Not released yet";
        }
        else {
            return short_description;
        }

    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", num_reviews_total=" + num_reviews_total +
                ", short_description='" + getShort_description() + '\'' +
                ", isFree=" + isFree +
                '}';
    }
}