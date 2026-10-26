package Vyuka.OOP.inheritance;

import javax.print.Doc;

public class Doctor {
    final static int BASE_SALARY = 50000;
    String name;
    int salary;

    Doctor (String name){
        this.name = name;
        salary = BASE_SALARY;
    }

    void diagnose(){
        System.out.println("Figuring out what's wrong with you...");
        salary += 10000;
    }
}

class Surgeon extends Doctor{
    final static int SURGEON_BONUS = 25000;

    Surgeon (String name) {
        super(name);
        salary += SURGEON_BONUS;
    }

    void surgery(){
        System.out.println("Cutting you open...");
        salary += 20000;
    }
}

class CardiacSurgeon extends Surgeon{
    final static int CS_BONUS = 35000;

    CardiacSurgeon(String name) {
        super(name);
        salary += CS_BONUS;
    }

    void cardiacSurgery(){
        System.out.println("Cut my heart into pieces...");
        salary += 30000;
    }
}

class Hospital{
    public static void main(String[] args) {
        Doctor d = new Doctor("Karel");
        System.out.println(d.name);
        System.out.println(d.salary);
        d.diagnose();
        System.out.println(d.salary);

        Surgeon s = new Surgeon("Pepa");
        System.out.println(s.name);
        System.out.println(s.salary);
        s.diagnose();
        s.surgery();
        System.out.println(s.salary);

        CardiacSurgeon cs = new CardiacSurgeon("Franta");
        System.out.println(cs.name);
        System.out.println(cs.salary);
        cs.diagnose();
        cs.surgery();
        cs.cardiacSurgery();
        System.out.println(cs.salary);
    }
}