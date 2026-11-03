package vlastni.OOP;

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


    public static void main(String[] args) {
        Basics obje = new Basics();
    }
}
