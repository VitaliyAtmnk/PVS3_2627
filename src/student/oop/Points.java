package student.oop;

public class Points {
    class Point{
        String name;
        double x, y,z;
        final double DEAFAULT_Z = 0;
        static int PointsCreated = 1;


        public Point(String name, double x, double y, double z) {
            this(name, x, y);
            this.z = z;
        }

        public Point(String name, double x, double y) {
            this.name = name;
            this.x = x;
            this.y = y;
            z = DEAFAULT_Z;
        }

        public Point(double x, double y, double z) {
            name = "point " + PointsCreated;
            this.x = x;
            this.y = y;
            z = DEAFAULT_Z;
            Point.PointsCreated ++;
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

        public double getZ() {return z;}

        public void setZ(double z) {
            this.z = z;
        }

        public static int getPointsCreated() {
            return PointsCreated;
        }


    }


}

