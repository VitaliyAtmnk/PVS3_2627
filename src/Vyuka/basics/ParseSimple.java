package Vyuka.basics;

import java.util.Arrays;
public class ParseSimple {
    public static void main(String[] args) {
        String something = "This is a number:3:2:1:0";

        //something.substring(something.indexOf(":")); //rozdeleni retezce
        String[]tokens = something.split(":");
            System.out.println("Tokens: " + Arrays.toString(tokens));

        //predelani na cislo
        int parsedNumber = Integer.parseInt(tokens[2]);
            System.out.println(parsedNumber);
    }
}
