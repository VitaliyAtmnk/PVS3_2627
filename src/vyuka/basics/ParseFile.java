package vyuka.basics;

import fileworks.DataExport;
import fileworks.DataImport;

public class ParseFile {
    public static void main(String[] args) {
        String path = "data/countries.txt";
        DataImport di = new DataImport(path);
        DataExport de = new DataExport("output.txt");

        String max = "";
        double maxn = Double.MIN_VALUE;

        String min = "";
        double minn = Double.MAX_VALUE;
        while(di.hasNext()){
            String[] line = di.readLine().split(";");
            if (Double.parseDouble(line[3])>maxn){
                max = line[0];
                maxn = Double.parseDouble(line[3]);
            }
            if (Double.parseDouble(line[2])<minn){
                min = line[0];
                minn = Double.parseDouble(line[2]);
            }

            //Country c = new Country(line[0], line[1], Double.parseDouble(line[2]), Double.parseDouble(line[3]));
            //c.printCountry();
            //System.out.println(c.toString());
//
            //if (line[1].equals("Europe")){
            //    de.writeLine(line.toString());
            //}


        }
        System.out.println("Nejvyšší avg age má "+max+" a to "+maxn);
        System.out.println("Nejnižší populaci má "+min+" a to "+ minn);

        de.finishExport();
        di.finishImport();
    }
}
