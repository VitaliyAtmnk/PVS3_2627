package Vyuka.OOP.interfaces;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparingBasics {

    static void printList(ArrayList<Item> items){
        for (Item i : items){
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("potato", 100, 0.33));
        items.add(new Item("bramburky", 500, 2));
        items.add(new Item("Pilsner Urquell 12°", 1000, 1.5));
        items.add(new Item("kure na paprice", 5, 8));

        printList(items);
        System.out.println("\n");

        Collections.sort(items);
        printList(items);
        System.out.println("\n");

        items.sort(Item.BY_TOTAL_PRICE);
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

    public static final Comparator<Item> BY_TOTAL_PRICE = new Comparator<Item>() {
        @Override
        public int compare(Item o1, Item o2) {
            double totalPrice1 = o1.price * o1.quantity;
            double totalPrice2 = o2.price * o2.quantity;
            return Double.compare(totalPrice1, totalPrice2);
        }
    };

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + ", " + quantity + "×, " + price + "$, " + "total price: " + price * quantity;
    }

    @Override
    public int compareTo(Item o) {
        return this.name.compareTo(o.name);
    }

    /*
    @Override
    public int compareTo(Item o) {
        return Double.compare(this.price, o.price);
    }

    @Override
    public int compareTo(Item o) {
        return Integer.compare(this.quantity, o.quantity);
    }
    */
}