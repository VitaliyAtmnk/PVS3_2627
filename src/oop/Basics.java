package oop;

public class Basics {

    // Metoda co vytváří objekt
    public Basics(){
        System.out.println("Zavolán konstruktor A");
    }

    public Basics(int a){
        System.out.println("Zavolán konstruktor B");
    }

    public Basics(String a){
        System.out.println(a);
    }

    public void soucet(double a, int b){
        System.out.println(a + b);
    }
    public int soucet(int a, int b){
        return a + b;
    }

    public static void main(String[] args) {
        Basics obj = new Basics();
        Basics obj2 = new Basics(1);
        Basics obj3 = new Basics("asdasda");

        obj.soucet(1.0, 5);
    }
}
