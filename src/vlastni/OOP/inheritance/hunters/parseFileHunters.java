package vlastni.OOP.inheritance.hunters;

import fileworks.DataImport;

import java.util.ArrayList;

public class parseFileHunters {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/hunters");
        ArrayList<Hunter>hunters = new ArrayList<>();
        while(di.hasNext()){
            String line = di.readLine();
            String[]tokens = line.split(",");

        }
    }
}
