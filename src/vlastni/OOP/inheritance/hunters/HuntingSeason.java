package vlastni.OOP.inheritance.hunters;

import java.util.ArrayList;
import java.util.Random;

public class HuntingSeason {

    public static void main(String[] args) {


        ArrayList<Hunter> hunters = new ArrayList<>();

        hunters.add(new Hunter("Theodore Roosvelt"));
        hunters.add(new Soldier("Jack Carter"));
        hunters.add(new Soldier("Ondřej Wislocki"));
        hunters.add(new Witcher("Gerald"));
        hunters.add(new Witcher("Vesemir"));
        int pocetZakazek = 100;

        Random rng = new Random();
        int randomIndex;
        for (int i = 0; i < pocetZakazek; i++) {
            randomIndex = rng.nextInt(0,hunters.size());
            randomJob(hunters.get(randomIndex));
        }
        Hunter bestHunter = hunters.getFirst();
        for (Hunter h : hunters){
            if (h.gold > bestHunter.gold){
                bestHunter = h;
            }
        }
        System.out.println("Nejlepší lovec: " + bestHunter.name + ", dosáhl " + bestHunter.gold + " zlaťáků");



    }
    static void randomJob(Hunter h){
        Random r = new Random();
        int rng = r.nextInt(1,4);
        switch (rng){
            case 1:

                h.hunt();
                break;
            case 2:
                if (h instanceof Soldier){
                    ((Soldier)h).killBandit();
                }
                else{
                    System.out.println(h.name + " byl penalizován, -10 zlaťáků");
                    h.gold-=10;
                }

                break;
            case 3:
                if (h instanceof Witcher){
                    ((Witcher)h).slayMonster();
                }
                else{
                    System.out.println(h.name + " byl penalizován, -10 zlaťáků");
                    h.gold-=10;
                }
                break;
        }

    }
}
