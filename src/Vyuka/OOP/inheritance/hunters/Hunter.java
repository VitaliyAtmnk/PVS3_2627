package Vyuka.OOP.inheritance.hunters;

import java.util.ArrayList;
import java.util.Random;

public class Hunter {
    String name;
    int gold;

    public Hunter(String name) {
        this.gold = 10;
        this.name = name;
    }

    public void hunt(){
        System.out.println(name + " is hunting a beast.");
        gold += 10;
    }
}

class Soldier extends Hunter{

    public Soldier(String name) {
        super(name);
        gold += 40;
    }

    public void killBandit(){
        System.out.println(name + " is going against bandits.");
        gold += 100;
    }
}

class Witcher extends Soldier{

    public Witcher(String name) {
        super(name);
        gold += 50;
    }

    public void slayMonster(){
        System.out.println(name + " is hunting for a monster.");
        gold += 250;
    }

    @Override
    public void hunt() {
        System.out.println(name + " is hunting a beast and he's very good at it.");
        gold += 50;
    }
}

class HuntingSeason{
    static void randomJob(Hunter hunter){
        Random rndm = new Random();
        int random = rndm.nextInt(1, 4);

        switch (random){
            case 1: {
                hunter.hunt();
            }
            case 2: {
                if (hunter instanceof Soldier){
                    ((Soldier) hunter).killBandit();
                }
            }
            case 3: {
                if (hunter instanceof Witcher){
                    ((Witcher) hunter).slayMonster();
                }
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Hunter> hunters = new ArrayList<>();
        hunters.add((new Hunter ("Bard")));
        hunters.add((new Soldier("Ciri")));
        hunters.add((new Soldier("Mysilov")));
        hunters.add((new Witcher("Geralt")));
        hunters.add((new Witcher("Vesemir")));

        int pocetZakazek = 100;

        Random rndm = new Random();
        int randomIndex;

        for (int i = 0; i < pocetZakazek; i++) {
            randomIndex = rndm.nextInt(0, hunters.size());
            randomJob(hunters.get(randomIndex));
        }


        Hunter nejlepsiHunter = hunters.getFirst();
        for (Hunter hunter : hunters){

            System.out.println(hunter.name + " ma tolik zlata: " + hunter.gold);
            if (hunter.gold > nejlepsiHunter.gold){
                nejlepsiHunter.gold = hunter.gold;
            }
        }
        System.out.println("Best hunter: " + nejlepsiHunter.name + ", gold: " + nejlepsiHunter.gold);
    }
}