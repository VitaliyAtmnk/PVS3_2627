package vlastni.oop.interfaces;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparingBasics {

    static void printList(ArrayList<Item> items){
        for (Item i : items){
            System.out.println(i);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Potato", 100, 0.33));
        items.add(new Item("White Monster", 1_000_000, 1.65));
        items.add(new Item("Mango Monster", 500_000, 1.65));
        items.add(new Item("Beef steak", 100_000, 11.5));

//        System.out.println(items);


        Collections.shuffle(items);
        printList(items);
        //serad, podle defaultniho (prirozeneho) razeni
        Collections.sort(items);
        printList(items);

//        //anonymni vnitrni trida
//        Comparator<Item> BY_PRICE = new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return 0;
//            }
//        };
    }
}
class Item implements Comparable<Item>{
    String name;
    int quantity;
    double price;
    public static Comparator<Item> BY_PRICE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o1.price,o2.price);
        }
    };
    public static Comparator<Item> BY_TOTAL_PRICE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            double totalPrice1 = o1.price* o1.quantity;
            double totalPrice2 = o2.price* o2.quantity;
            return Double.compare(totalPrice1,totalPrice2);
        }
    };
    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + quantity+ "x $" + price;
    }
//      PODLE MNOZSTVI
//    @Override
//    public int compareTo(Item o) {
//        return this.quantity - o.quantity;
//    }

//  PODLE CENY
//    @Override
//    public int compareTo(Item o) {
////        return (int) (this.price - o.price);
//        return Double.compare(this.price, o.price);
//    }

    //PODLE JMENA

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.name);
    }
}
