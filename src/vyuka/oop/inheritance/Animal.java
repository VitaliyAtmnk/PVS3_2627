package vyuka.oop.inheritance;

import fileworks.DataImport;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    public String name;
    public double energy;

    public Animal(String name, double energy) {
        this.name = name;
        this.energy = energy;
    }

    public void eat() {
        energy += Math.exp(-energy);
    }

    public void makeNoise() {
        System.out.println("Make some noise");
    }
}

class Dog extends Animal {
    public String breed;

    public Dog(String name, double energy, String breed) {
        super(name, energy);
        this.breed = breed;
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

class Pig extends Animal {
    int mudLevel;

    public Pig(String name, double energy) {
        super(name, energy);
    }

    public Pig(String name, double energy, int mudLevel) {
        super(name, energy);
        this.mudLevel = mudLevel;
    }

    void playInMud() {
        mudLevel += 10;
        mudLevel = Math.min(mudLevel, 100);
    }

    @Override
    public void makeNoise() {
        System.out.println("Oink (Chrocht)");
    }
}

class Main {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/animals.txt");

        // přeskočit hlavičku
        di.readLine();

        List<Animal> animals = new ArrayList<>();

        while (di.hasNext()) {
            String[] parts = di.readLine().trim().split(";");
            switch (parts[0]) {
                case "Dog":
                    animals.add(new Dog(
                            parts[2],
                            Double.parseDouble(parts[1]),
                            parts[3]
                    ));
                    break;
                case "Cat":
                    animals.add(new Cat(
                            parts[2],
                            Double.parseDouble(parts[1])
                    ));
                    break;
                case "Pig":
                    animals.add(new Pig(
                            parts[2],
                            Double.parseDouble(parts[1]),
                            Integer.parseInt(parts[4])
                    ));
                    break;
            }
        }
        for(Animal animal : animals) {
            if(animal instanceof Dog) {
                System.out.println(((Dog) animal).breed);
            }
        }
    }
}
