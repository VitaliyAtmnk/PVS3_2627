package oop.inheritance;

import java.util.ArrayList;

public class CardiacSurgeon extends Surgeon{

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
