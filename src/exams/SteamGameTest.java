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

        String line;
        String[] params;

        // TODO: načíst soubor do arraylistu

        while (di.hasNext()) {
            line = di.readLine();
            params = line.split("\t");
            switch (params.length) {
                case 3:
                    games.add(new Game(params[0],
                            Double.parseDouble(params[1]),
                            Long.parseLong(params[2])));
                    break;
                case 4:
                    games.add(new Game(params[0],
                            Double.parseDouble(params[1]),
                            Long.parseLong(params[2]),
                            params[3]));
                    break;
            }
        }

        System.out.println("Games total loaded: " + games.size());

        System.out.println("Number of free games: " + totalFreeGames(games));
        System.out.println("Average number of reviews per game: " + avgReviewPerGame(games));
        System.out.println("The most expensive game is: " + mostExpansive(games));

        System.out.println(games.get(0));                   // zdarma
        System.out.println(games.get(games.size() / 2));    // placené

        // Nejlevnější hra s nejvíce hodnocením
        System.out.println("Best free game: " + bestFreeGame(games));

        di.finishImport();
    }

    private static String mostExpansive(List<Game> games) {
        // TODO: vrátit nejdražší hru
        double maxPrice = Double.MIN_VALUE;
        String maxPriceName = "";
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getPrice() > maxPrice) {
                maxPrice = games.get(i).getPrice();
                maxPriceName = games.get(i).getName();
            }
        }
        return maxPrice + " " + maxPriceName;
    }

    private static long totalFreeGames(List<Game> games) {
        // TODO: vrátit počet her, které jsou zdarma
        int countFree = 0;
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getPrice() == 0.0) countFree++;
        }
        return countFree;
    }
    private static double avgReviewPerGame(List<Game> games) {
        // TODO: vrátit průměrný počet hodnocení
        long reviewTotal = 0;
        for (int i = 0; i < games.size(); i++) {
            reviewTotal += games.get(i).getNumReviews();
        }
        return (double) reviewTotal / games.size();
    }
    private static String bestFreeGame(List<Game> games) {
        long mostReviews = Long.MIN_VALUE;
        String name = "";
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getPrice() == 0.0) {
                if(games.get(i).getNumReviews() > mostReviews) {
                    mostReviews = games.get(i).getNumReviews();
                }
            }
        }
        for (int i = 0; i < games.size(); i++) {
            if(games.get(i).getNumReviews() == mostReviews) {
                name = games.get(i).getName();
                break;
            }
        }
        return name + " with " + mostReviews + " reviews";
    }
}

class Game {
    private String name;
    private double price;
    private long numReviews;
    private String description;

    public Game(String name, double price, long numReviews) {
        this.name = name;
        this.price = price;
        this.numReviews = numReviews;
        if(getDescription() == null && getPrice() == 0.0) this.description = "zdarma";
        else if (getDescription() == null) this.description = "Not released yet";
    }

    public Game(String name, double price, long numReviews, String description) {
        this(name, price, numReviews);
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public long getNumReviews() {
        return numReviews;
    }

    public String getDescription() {
        return description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setNumReviews(long numReviews) {
        this.numReviews = numReviews;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", numReviews=" + numReviews +
                ", description='" + description + '\'' +
                '}';
    }

    // TODO: attributy, konstruktor(y), gettery/settery + minimálně toString()
    // TODO: getter pro krátký popisek bude vracet "Not released yet" pokud není popisek uveden hra je "zdarma"
}