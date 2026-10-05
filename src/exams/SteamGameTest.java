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

        return null; // tento řádek smažte
    }

    private static long totalFreeGames(List<Game> games) {
        // TODO: vrátit počet her, které jsou zdarma

        return 0L; // tento řádek smažte
    }
    private static double avgReviewPerGame(List<Game> games) {
        // TODO: vrátit průměrný počet hodnocení

        return 0.0; // tento řádek smažte
    }
}

class Game {
    // TODO: attributy, konstruktor(y), gettery/settery + minimálně toString()
    // TODO: getter pro krátký popisek bude vracet "Not released yet" pokud není popisek uveden hra je "zdarma"
}