package basics;

import fileworks.DataExport;

import java.util.Random;

public class Showcase {

    public static void main(String[] args) {
        //ukazka nezavreni output

        DataExport de = new DataExport("example.txt");

        //random, var A
        Random generator = new Random();
        generator.nextInt(-200000,200000);
        //varianta B, Math.random
//        int a = (int) (Math.random()*400001-200000);
//        int min = -200000;
//        int max = 200000;
//        int b = (int) (Math.random()*(max-min+1) + min);

        for (int i = 0; i < 1_000_000; i++) {
            de.writeLine(String.valueOf(generator.nextInt(-200000,200000)));
//            de.writeLine(""+generator.nextInt(-200000,200000));
        }

        de.finishExport();
    }
}
