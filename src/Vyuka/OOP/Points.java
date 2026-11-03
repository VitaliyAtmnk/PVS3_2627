package Vyuka.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

class Point{
   private String name;
   private Double x, y, z;
   private final double DEFAULT_Z = 0;
   private static int pointsCreated = 1;

    public static int getPointsCreated() {
        return pointsCreated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Point(String name, Double x, Double y, Double z) {
        this(name, x, y);
        this.z = z;
    }

    public Point(String name, Double x, Double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        z = DEFAULT_Z;
    }

    public Point(Double x, Double y) {
        this.x = x;
        this.y = y;
        z = DEFAULT_Z;
        name = "Point#" + pointsCreated;
        pointsCreated++;
    }

    @Override
    public String toString (){
        return name + " " + x + " " + y + " " +z;
    }
}



public class Points {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/points.txt");
        ArrayList<Point> points = new ArrayList<>();

        String line;
        String[] tokens;

        while (di.hasNext()){
            line = di.readLine();
            tokens = line.split(",");

            switch (tokens.length){
                case 2 : points.add(new Point(Double.parseDouble(tokens[0]),
                        Double.parseDouble(tokens[1])));
                    break;
                case 3 : points.add(new Point(tokens[0],
                        Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2])));
                    break;
                case 4 : points.add(new Point(tokens[0],
                        Double.parseDouble(tokens[1]),
                        Double.parseDouble(tokens[2]),
                        Double.parseDouble(tokens[3])));
                    break;
            }

        }


        di.finishImport();
    }
}
