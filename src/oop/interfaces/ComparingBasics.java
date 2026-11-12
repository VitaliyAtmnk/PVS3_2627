package oop.interfaces;


import javax.lang.model.type.MirroredTypeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
        items.add(new Item("white Monster", 1_000_000, 1.65));
        items.add(new Item("Mango Monster", 500_000, 1.65));
        items.add(new Item("Beef steak", 100_000, 11.5));

//        System.out.println(items);


        Collections.shuffle(items);
        printList(items);
        //serad, podle defaultniho (prirozeneho) razeni
        Collections.sort(items);
        printList(items);

        //anonymni vnitrni trida
//        Comparator<Item> BY_PRICE = new Comparator<Item>() {
//            @Override
//            public int compare(Item o1, Item o2) {
//                return 0;
//            }
//        };

        items.sort(Item.BY_PRICE);
        printList(items);
        items.sort(Item.BY_PRICE.reversed());
        printList(items);
    }
}
class Item implements Comparable<Item>{
    String name;
    int quantity;
    double price;

    public static final Comparator<Item> BY_PRICE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Double.compare(o1.price, o2.price);
        }
    };

    public static final Comparator<Item> BY_QTY = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            return Integer.compare(o1.quantity, o2.quantity);
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

    //PODLE JMENA - abecedne
    @Override
    public int compareTo(Item o) {
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }
}
