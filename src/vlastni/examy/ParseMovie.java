package vlastni.examy;

import fileworks.DataExport;
import fileworks.DataImport;

public class ParseMovie {
    public static void main(String[] args) {
        String fileName = "data/movieList.txt";
        int moviesAfter2000 = 0;
        Movie bestRating = new Movie("h",69420,"action",Double.MIN_VALUE);

        DataImport di = new DataImport(fileName);
        DataExport de = new DataExport("horrors.txt");
        while(di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");
            String name = tokens[0];
            int year = Integer.parseInt(tokens[1]);
            String genre = tokens[2];
            double rating = Double.parseDouble(tokens[3]);
            Movie m = new Movie(name, year,genre,rating);
            if (bestRating.getRating() < m.getRating()){
                bestRating = m;
            }
            if (m.getYear() > 2000){
                moviesAfter2000++;
            }
            if ((m.getGenre().equals("Horror"))){
                de.writeLine(m.toString());

            }
        }
        System.out.println("Film s největším ratingem: " +bestRating);
        System.out.println("Počet filmů s vydáním po roce 2000: " +moviesAfter2000);

        di.finishImport();
        de.finishExport();
    }

}
