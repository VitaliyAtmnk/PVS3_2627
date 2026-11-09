package student.oop.inheritance;

import basics.ParseFile;
import fileworks.DataImport;

import java.util.ArrayList;

public class Animal {
    protected String name;
    private double energy;

    public void eat() {
        energy += Math.exp(-energy);
    }

    public void makeNoise() {
        System.out.println("Make some noise");
    }

    public Animal(String name, double energy) {
        this.name = name;
        this.energy = energy;
    }
}

class Dog extends Animal {
    public String breed;

    public Dog(String name, double energy, String bree) {
        super(name, energy);
        breed = bree;
    }


    @Override
    public void makeNoise() {
        System.out.println("Haf");
    }
}

class Cat extends Animal {

    public Cat(String name, double energy) {
        super(name, energy);
    }

    @Override
    public void makeNoise() {
        System.out.println("Moew");
    }

}

class Pig extends Animal{
    int mudlevel;

    public Pig(String name, double energy, int mud) {
        super(name, energy);
        mudlevel = mud;
    }

    void playInMud(){
        mudlevel += 10;
        mudlevel = Math.min(mudlevel, 100);
    }

    @Override
    public void makeNoise() {
        System.out.println("Oink");
    }
}


class Main {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/animals.txt");
        di.readLine();
        ArrayList<Animal> animals = new ArrayList<>();
        while (di.hasNext()){
            String line = di.readLine();
            String[] parts = line.trim().split(";");
            switch (parts[0]){
                case "Dog": {
                    animals.add(new Dog(parts[2],
                            Integer.parseInt(parts[1]),
                            parts[3]
                    ));
                    break;
                }

                case "Cat": {
                    animals.add(new Cat(parts[2],
                            Integer.parseInt(parts[1])
                    ));
                    break;
                }

                case "Pig": {
                    animals.add(new Pig(parts[2],
                            Integer.parseInt(parts[1]),
                            Integer.parseInt(parts[3])
                    ));
                    break;
                }
            }

        }
        for (Animal animal : animals){
            if (animal instanceof  Dog){
                System.out.println(((Dog) animal).breed);
            }
        }
    }
}
