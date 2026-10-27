package oop.inheritance.hunters;

import java.util.ArrayList;
import java.util.Random;

public class HuntingSeason {
    private static final int SEED = 123456789;

    static void randomJob(Hunter hunter) {
        Random rng = new Random(SEED);
        int random = rng.nextInt(1, 4);

        switch (random) {
            case 1: {
                hunter.hunt();
            }
            case 2: {
                if (hunter instanceof Soldier) {
                    ((Soldier) hunter).killBandits();
                } else {
                    hunter.gold -= 10; // penalizace
                }
            }
            case 3: {
                if (hunter instanceof Witcher) {
                    ((Witcher) hunter).slayMonster();
                } else {
                    hunter.gold -= 10; // penalizace
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Hunter> hunters = new ArrayList<>();
        hunters.add(new Hunter("Theodore Roosvelt"));
        hunters.add(new Soldier("Jack Carter"));
        hunters.add(new Soldier("Ondřej Wislocki"));
        hunters.add(new Witcher("Geralt"));
        hunters.add(new Witcher("Vesemír"));

        int pocetZakazek = 100;

        Random rng = new Random(SEED);
        int randomIndex;

        for (int i = 0; i < pocetZakazek; i++) {
            randomIndex = rng.nextInt(0, hunters.size());
            randomJob(hunters.get(randomIndex));
        }

        Hunter best = hunters.getFirst();

        for(Hunter hunter : hunters){
            if(hunter.gold > best.gold){
                best = hunter;
            }
        }

        System.out.println(best);
    }
}
