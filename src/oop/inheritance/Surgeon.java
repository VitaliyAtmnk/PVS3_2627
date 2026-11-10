package oop.inheritance;

public class Surgeon extends Doctor {
    final static int SURGEON_BONUS = 2500;

    public Surgeon(String name) {
        super(name);
        salary += SURGEON_BONUS;
    }

    public void surgery(){
        System.out.println("Cutting you open...");
        salary += 20000;
    }
}
