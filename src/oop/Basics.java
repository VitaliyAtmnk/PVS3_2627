package oop;

public class Basics {
    public static void main(String[] args) {

//        obj.soucet(1.0, 5);

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
