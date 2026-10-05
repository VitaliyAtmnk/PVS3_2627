package oop;

import fileworks.DataImport;

import java.util.ArrayList;

public class Points {
    //tady se deje nejaka magie
    public static void main(String[] args) {
        Point a = new Point(44.5, 22.1);
        Point b = new Point(44.5, 22.1);
        Point c = new Point(44.5, 22.1);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(a);
        System.out.println("Points created: " + Point.getPointsCreated());

        ArrayList<Point> points = new ArrayList<>();
        DataImport di = new DataImport("data/points.txt");

        String line;
        String[] params;
        while (di.hasNext()) {
            line = di.readLine();
            params = line.split(",");

            switch (params.length) {
                case 2:
                    points.add(new Point(Double.parseDouble(params[0]),
                            Double.parseDouble(params[1])));
                    break;
                case 3:
                    points.add(new Point(params[0],
                            Double.parseDouble(params[1]),
                            Double.parseDouble(params[2])));
                    break;
                case 4:
                    points.add(new Point(params[0],
                            Double.parseDouble(params[1]),
                            Double.parseDouble(params[2]),
                            Double.parseDouble(params[3])));
                    break;
            }

        }
        di.finishImport();
        System.out.println(points);
        for (Point point : points){
            System.out.println(point);
        }



    }
}

class Point {
    private String name;
    private double x, y, z;
    private final double DEFAULT_Z = 0;
    //pomocne pocitadlo = globalni promenna
    private static int pointsCreated = 1;

    public Point(String name, double x, double y, double z) {
        this(name, x, y);
        this.z = z;
    }

    public Point(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        z = DEFAULT_Z;
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        z = DEFAULT_Z;
        name = "Point#" + pointsCreated;
        pointsCreated++;
    }

    @Override
    public String toString() {
        return name + "(" + x + ", " + y + ", " + z + ")";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public static int getPointsCreated() {
        return pointsCreated;
    }
}