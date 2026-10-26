package vyuka.oop.inheritance.hunters;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.Random;

public class HuntingSeason {
    static void randomJob(Hunter hunter) {
        Random rng = new Random();
        int random = rng.nextInt(1, 4);
        switch (random) {
            case 1:
                hunter.hunt();
                break;
            case 2:
                if (hunter instanceof Soldier) ((Soldier) hunter).killBandits();
                else hunter.gold -= 10;
                break;
            case 3:
                if (hunter instanceof Witcher) ((Witcher) hunter).slayMonster();
                else hunter.gold -= 10;
                break;
        }
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/hunters.txt");

        ArrayList<Hunter> hunters = new ArrayList<>();

        while(di.hasNext()) {
            String[] hunter = di.readLine().split(",");
            switch (hunter[1]) {
                case "Hunter":
                    hunters.add(new Hunter(hunter[0],hunter[1]));
                    break;
                case "Soldier":
                    hunters.add(new Soldier(hunter[0],hunter[1]));
                    break;
                case "Wither":
                    hunters.add(new Witcher(hunter[0],hunter[1]));
                    break;
            }
        }



        hunters.add(new Hunter("Theodore Roosvelt"));
        hunters.add(new Soldier("Jack Carter"));
        hunters.add(new Soldier("Ondřej Wislocki"));
        hunters.add(new Witcher("Geralt"));
        hunters.add(new Witcher("Vesemír"));

        int jobsNum = 100;

        Random rng = new Random();
        int randomIndex;

        for (int i = 0; i < jobsNum; i++) {
            randomIndex = rng.nextInt(0, hunters.size());
            randomJob(hunters.get(randomIndex));
        }

        int bestHuntersMoney = Integer.MIN_VALUE;
        String bestHuntersName = null;

        for (int i = 0; i < hunters.size(); i++) {
            if(hunters.get(i).gold > bestHuntersMoney) {
                bestHuntersMoney = hunters.get(i).gold;
                bestHuntersName = hunters.get(i).name;
            }
        }

        System.out.println();
        System.out.println("Theodor Roosvelt earned " + hunters.get(0).gold + " gold");
        System.out.println("Jack Carter earned " + hunters.get(1).gold + " gold");
        System.out.println("Ondřej Wislocki earned " + hunters.get(2).gold + " gold");
        System.out.println("Geralt earned " + hunters.get(3).gold + " gold");
        System.out.println("Vesemír earned " + hunters.get(4).gold + " gold");
        System.out.println();

        System.out.println("The best hunter was " + bestHuntersName + " who earned " + bestHuntersMoney + " gold!");
    }
}
