package oop.inheritance.hunters;

import fileworks.DataImport;

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

    static void processTasks(Hunter hunter, String[] taskList){
        //preskakuju jmeno + roli (alternativa by byla kopie pole)
        for (int i = 2; i < taskList.length; i++) {
            switch (taskList[i]){
                case "K":
                    if (hunter instanceof Soldier) {
                        ((Soldier) hunter).killBandits();
                    } else {
                        hunter.gold -= 10; // penalizace
                    }
                    break;
                case "M":
                    if (hunter instanceof Witcher) {
                        ((Witcher) hunter).slayMonster();
                    } else {
                        hunter.gold -= 10; // penalizace
                    }
                    break;
                default:
                    hunter.hunt();
                    break;
            }
        }
    }

    static void loadData(String filePath, ArrayList<Hunter> hunters){
        DataImport di = new DataImport(filePath);
        String line;
        String[] lineParams;
        Hunter currentHunter;
        while (di.hasNext()){
            line = di.readLine();
            lineParams = line.split(",");
            switch (lineParams[1]){
                case "Soldier":
                    currentHunter = new Soldier(lineParams[0]);
                    break;
                case "Witcher":
                    currentHunter = new Witcher(lineParams[0]);
                    break;
                default:
                    currentHunter = new Hunter(lineParams[0]);
                    break;
            }
            hunters.add(currentHunter);
        }
        di.finishImport();
    }

    public static void main(String[] args) {
        ArrayList<Hunter> hunters = new ArrayList<>();
        //pokud se podari nacist soubor,
        // zpracuj, jinak pokracuj v main
        loadData("Data/hunters.txt", hunters);
        if (hunters.isEmpty()){
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
