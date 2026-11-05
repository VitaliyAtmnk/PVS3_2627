package vyuka.oop.interfaces;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparingBasics {

    static void printList(ArrayList<Item> items) {
        for (Item i : items) {
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("potato", 100, 0.33));
        items.add(new Item("White Monster", 1_000_000, 1.65));
        items.add(new Item("Mango Monster", 500_000, 1.65));
        items.add(new Item("Beef Steak", 100_000, 11.5));

        Collections.shuffle(items);

        printList(items);
        // seřaď podle defaultního (přirozrného) řazení
        Collections.sort(items);

        System.out.println();

        printList(items);

        // anonymní vnitřní třída
        Comparator<Item> BY_PRICE = new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return 0;
            }
        };
    }
}

class Item implements Comparable<Item>{
    String name;
    int quantity;
    double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + quantity + "x $" + price;
    }

//    @Override
//    public int compareTo(Item o) {
//        return this.quantity - o.quantity;
//    }

// PODLE CENY
//    @Override
//    public int compareTo(Item o) {
////        return (int) (this.price - o.price);
//        return Double.compare(this.price, o.price);
//    }

// PODLE JMENA

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.name);
    }
}
