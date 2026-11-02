package PRG.OOP.INHERITANCE;

import java.util.ArrayList;
import java.util.Random;

class Hunter {

    String name;
    int gold;

    public Hunter(String name) {

        this.name = name;
        gold = 10;
    }

    public void hunt() {

        System.out.println(name + " is hunting...");
        gold += 10;
    }

    @Override
    public String toString() {

        if (getClass() == Hunter.class) {

            return "Hunter " + name + " with " + gold + " gold";
        }

        if (getClass() == Soldier.class) {

            return "Soldier  " + name + " with " + gold + " gold";
        }

        if (getClass() == Witcher.class) {

            return "Witcher  " + name + " with " + gold + " gold";
        }

        return getClass().getName() + "@" + Integer.toHexString(hashCode());
    }
}

class Soldier extends Hunter {

    public Soldier(String name) {

        super(name);
        gold = 20;
    }

    @Override
    public void hunt() {

        System.out.println(name + " is hunting even better...");
        gold += 20;
    }

    public void killBandit() {

        System.out.println(name + " is killing bandit...");

        gold += 40;
    }
}

class Witcher extends Soldier {

    public Witcher(String name) {

        super(name);
        gold = 30;
    }

    @Override
    public void hunt() {

        System.out.println(name + " is hunting a dragon...");
        gold += 30;
    }

    public void doMagic() {

        System.out.println(name + " is doing some magic...");
        gold += 60;
    }
}

public class HuntingSeason {

    static void randomJob(Hunter hunter) {

        Random randomJobGen = new Random();
        int randomJobNumber = randomJobGen.nextInt(1, 4);

        switch (randomJobNumber) {

            case 1 -> hunter.hunt();

            case 2 -> {
                if (hunter instanceof Soldier) {
                    ((Soldier) hunter).killBandit();
                }
            }

            case 3 -> {
                if (hunter instanceof Witcher) {
                    ((Witcher) hunter).doMagic();
                }
            }
        }
    }

    static void main() {

        ArrayList<Hunter> hunters = new ArrayList<>();

        hunters.add(new Hunter("Habira"));
        hunters.add(new Soldier("Flinta"));
        hunters.add(new Soldier("Marek"));
        hunters.add(new Witcher("Žampion"));

        int pocetZakazek = 100;

        Random randomHunter = new Random();
        int randomIndex;

        for (int i = 0; i < pocetZakazek; i++) {

            randomIndex = randomHunter.nextInt(0, hunters.size());

            randomJob(hunters.get(randomIndex));
        }

        Hunter bestHunter = hunters.getFirst();

        for (Hunter hunter : hunters) {

            if (hunter.gold > bestHunter.gold) {

                bestHunter = hunter;
            }
        }

        System.out.println("\n " + bestHunter.toString());
    }
}