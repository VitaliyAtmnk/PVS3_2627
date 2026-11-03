package vlastni.OOP;

import fileworks.DataImport;

import java.util.ArrayList;

public class Points {
    public static void main(String[] args) {
        ArrayList<Point> points = new ArrayList<>();
        DataImport di = new DataImport("data/points.txt");

        String[]params;
        while (di.hasNext()){
            String line = di.readLine();
            params = line.split(",");

            switch (params.length){
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
    }

}

 class Point {
    String name;
    double x,y,z;
    final double DEFAULT_Z = 0;
    static  int pointsCreated = 1;

     public Point(String name, double x, double y, double z) {
         this(name, x, y);
         this.z = z;
     }

     public Point(String name, double x, double y) {
         this.name = name;
         this.x = x;
         this.y = y;
         this.z = DEFAULT_Z;
     }

     public Point(double x, double y) {
         this.x = x;
         this.y = y;
         z = DEFAULT_Z;
         this.name = "Point# " + pointsCreated;
         pointsCreated++;
     }

     @Override
     public String toString() {
         return "Point{" +
                 "name='" + name + '\'' +
                 ", x=" + x +
                 ", y=" + y +
                 ", z=" + z +
                 '}';
     }
 }



