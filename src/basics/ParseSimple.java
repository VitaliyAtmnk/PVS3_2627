package basics;

import java.util.Arrays;

public class ParseSimple {
    public static void main(String[] args) {
        String data = "This is a number:3";

        // data.substring(data.indexOf(':')); // rozdělit pomocí substringu
        String[] tokens = data.split(":");
        System.out.println("Tokens: " + Arrays.toString(tokens));


        int parsedNumber = Integer.parseInt(tokens[1]);
        System.out.println(parsedNumber * 2);
    }
}
