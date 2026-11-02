package oop.inheritance;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hospital {

    public static void main(String[] args) {
        Doctor doctor = new Doctor("Jeff");
        System.out.println(doctor.name);
        System.out.println(doctor.salary);
        doctor.diagnose();
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

        //tohle jeste pujde
        Doctor example = new CardiacSurgeon("Terry");
        example.diagnose();

        CardiacSurgeon terryCardiac = (CardiacSurgeon) example;
        //vytvorim promennoum, pretypuji a pouziji metodu
        terryCardiac.cardiacSurgery();

        //NEBO: rovnou pretypuji
        ((Surgeon) example).surgery();
        System.out.println(terryCardiac);
        System.out.println(example);

        System.out.println(example.getClass());

        if (example instanceof Surgeon){
            System.out.println(example.name + " je kardiochirurg");
        }

        //nebude fungovat
//        Surgeon s2 = new Doctor("David");



    }
}
