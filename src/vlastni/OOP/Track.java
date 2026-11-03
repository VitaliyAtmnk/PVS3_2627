package vlastni.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

public class Track {
    String name;
    int year;
    double rating;
    int duration;

    public Track(String name, int year, double rating, int duration) {
        this.name = name;
        this.year = year;
        this.rating = rating;
        setDuration(duration);
    }
    public void setDuration(int duration) {
        if (duration < 0 ){
            System.out.println("Invalid Duration");
        }
        else this.duration = duration;
    }

    public void setRating(double rating) {
        if (rating < 0.0 || rating > 10.0 ){
            System.out.println("Invalid Rating");
        }
        else this.rating = duration;
    }

    @Override
    public String toString() {
        return "Track{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", duration=" + duration +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getRating() {
        return rating;
    }

    public int getDuration() {
        return duration;
    }

    public static void main(String[] args) {
        DataImport di = new DataImport("data/tracks.txt");
        ArrayList<Track> tracks = new ArrayList<>();
        while(di.hasNext()){
            String line = di.readLine();
            String[] tokens = line.split(";");
            Track song = new Track(
                    tokens[0],
                    Integer.parseInt(tokens[1]),
                    Double.parseDouble(tokens[2]),
                    Integer.parseInt(tokens[3])
                    );
            tracks.add(song);
        }
        di.finishImport();
        //arraylist zaklady:
        System.out.println(tracks.get(0));
        System.out.println(tracks.get(tracks.size()-1));
    }

}
