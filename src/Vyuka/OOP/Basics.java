package Vyuka.OOP;

public class Basics {
    public static void main(String[] args) {

        Basics obj = new Basics(4);
        obj.soucet(2,5);
    }

    public void soucet (int b, int c){
        int soucet = b+c;
        System.out.println(soucet);
    }
    public Basics (int a){
            System.out.println(a);
        }
}
