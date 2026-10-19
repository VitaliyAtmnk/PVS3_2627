package oop.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    protected String name;
    private double energy;

    public void eat() {
        energy += Math.exp(-energy);
    }

    public void makeNoise() {
        System.out.println("Make some noise");
    }
}

class Dog extends Animal {
    public String breed;


    @Override
    public void makeNoise() {
        System.out.println("Haf");
    }
}

class Cat extends Animal {
    @Override
    public void makeNoise() {
        System.out.println("Moew");
    }

}

class Main {
    public static void main(String[] args) {
    }
}