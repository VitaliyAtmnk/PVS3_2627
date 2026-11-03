package oop.inheritance;

import exams.CardiacSurgeon;
import exams.Doctor;
import exams.Surgeon;

import java.util.LinkedList;
import java.util.List;

public class Hospitals {

    public static void main(String[] args) {
        Doctor doctor = new Doctor("Jeff");
        doctor.diagnose();
        System.out.println(doctor.name);
        System.out.println(doctor.salary);
        System.out.println();

        Surgeon s = new Surgeon("Pepa");
        System.out.println(s.name);
        System.out.println(s.salary);

        System.out.println();
        s.diagnose();
        s.surgery();

        CardiacSurgeon cs = new CardiacSurgeon("Max");
        System.out.println(cs);

        //tohle ještě půjde
        Doctor example = new CardiacSurgeon("Terry");
        example.diagnose();


        CardiacSurgeon terryCardiac = (CardiacSurgeon) example;
        //vytvořím proměnou, přetypuji a použiji metodu
        terryCardiac.cardiacSurgery();

        Doctor vojta = new Surgeon("Vojta");

        if (vojta instanceof Doctor) {
            System.out.println("Jsem z této třídy :-)");
        } else {
            System.out.println("Smolík");
        }


        int ranNumber = (int) (Math.random() * 5);


        //NEBO: rovnou přetypuji
        ((Surgeon) example).surgery();
        System.out.println(terryCardiac);
        System.out.println(example);

        System.out.println(example.getClass());

        if (example instanceof CardiacSurgeon) {
            System.out.println(example.name + " je kardiochirurg");
        }

        int a = (int) 4.5*5/2;

        List<String> words = new LinkedList<>();

        //Surgeon s2 = new Doctor("David");

    }
}
