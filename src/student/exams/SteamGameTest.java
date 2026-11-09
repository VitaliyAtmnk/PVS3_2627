package student.exams;

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
        while (di.hasNext()) {
            String line = di.readLine();
            String[] split = line.split("\t");
            Game game;
            if (split.length == 3) {
                game = new Game(
                        split[0],
                        Double.parseDouble(split[1]),
                        Integer.parseInt(split[2])
                );
            }
            else  {
                game = new Game(
                        split[0],
                        Double.parseDouble(split[1]),
                        Integer.parseInt(split[2]),
                        split[3]);
            }
            games.add(game);
        }
        // TODO: načíst soubor do arraylistu

        System.out.println("Games total loaded: " + games.size());

        System.out.println("Number of free games: " + totalFreeGames(games));
        System.out.println("Average number of reviews per game: " + avgReviewPerGame(games));
        System.out.println("The most expensive game is: " + mostExpansive(games));

        System.out.println(games.get(0));                   // zdarma
        System.out.println(games.get(games.size() / 2));    // placené
    }

    private static Game mostExpansive(List<Game> games) {
        // TODO: vrátit nejdražší hru
        Game mostgame = games.getFirst();
        for (Game game : games) {
            if (mostgame.getPrice() < game.getPrice()) {
                mostgame = game;
            }

        }
        return mostgame;

    }

    private static long totalFreeGames(List<Game> games) {
        // TODO: vrátit počet her, které jsou zdarma
        int freeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeegames = 0;
        for (Game game : games) {
            if (game.getPrice() == 0) {
                freeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeegames++;
            }

        }
        return freeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeegames;

    }
    private static double avgReviewPerGame(List<Game> games) {
        // TODO: vrátit průměrný počet hodnocení
        double avarige = 0.0;
        for (Game game : games) {
            avarige = avarige + game.getNum_reviews_total();
        }
        avarige = avarige/games.size();
        return avarige;
        //předpokladam že tohle ní jak jsem to měl viřešit :/


    }
}

class Game {
    // TODO: attributy, konstruktor(y), gettery/settery + minimálně toString()
    // TODO: getter pro krátký popisek bude vracet "Not released yet" pokud není popisek uveden a hra je "zdarma"
    private String name;
    private double price;
    private int num_reviews_total;
    private String short_description;

    public Game(String name, double price, int num_reviews_total, String short_description) {
        this.name = name;
        this.price = price;
        this.num_reviews_total = num_reviews_total;
        this.short_description = short_description;
    }

    public Game(String name, double price, int num_reviews_total) {
        this.name = name;
        this.price = price;
        this.num_reviews_total = num_reviews_total;
        if (price == 0){this.short_description = "Not released yet";}
        else this.short_description = "missing description";
    }

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
        if (price >=0) this.price = price;
        else this.price = 0;
    }

    public int getNum_reviews_total() {
        return num_reviews_total;
    }

    public void setNum_reviews_total(int num_reviews_total) {
        if (num_reviews_total >=0 )this.num_reviews_total = num_reviews_total;
        else this.num_reviews_total = 0;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    @Override
    public String toString() {
        return name +
                ", price: " + "$" + price  +
                ", total reviews: " + num_reviews_total +
                ", description: '" + short_description +"\n";
    }
    // TODO: attributy, konstruktor(y), gettery/settery + minimálně toString()
    // TODO: getter pro krátký popisek bude vracet "Not released yet" pokud není popisek uveden hra je "zdarma"
}