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

        for (int i = 0, j = 2; i < 10; i++, j+=2) {
            System.out.println(i+j);
        }
        int a = 100;
        for (;a >= 0; a-=10){
            System.out.println(a);
        }

        for (int i = 0; i < 200; i++) {
            for (int j = 0; j < 150; j++) {
                for (int k = 0; k < 100; k++) {
                    System.out.println(i+j+k);
                }
            }
        }
//        for (;;){
//            System.out.println("Still going..");
//        }
    }
}
