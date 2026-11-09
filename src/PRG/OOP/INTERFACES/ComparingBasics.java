package PRG.OOP.INTERFACES;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ComparingBasics {

    static void printList(ArrayList<Item> items) {

        for (Item i : items){

            System.out.println(i);
        }
    }

    static void main() {

        ArrayList<Item> items = new ArrayList<>();

        items.add(new Item("Hrušky", 100, 0.33));
        items.add(new Item("Oříšky", 500, 2));
        items.add(new Item("Ruby fantasy Monster", 10000, 1.5));
        items.add(new Item("Kuře na Habiře", 5, 8));

        printList(items);
        System.out.println();
        Collections.sort(items);
        printList(items);
        System.out.println("\n");
    }
}

class Item implements Comparable<Item> {

    String name;
    int quantity;
    double price;

    public static final Comparator<Item> BY_PRICE = new Comparator<Item>() {

        @Override
        public int compare(Item o1, Item o2) {

            if (o1.price > o2.price) {

                return 1;
            }

            else if (o1.price < o2.price) {

                return -1;
            }

            else return 0;
        }
    };

    public Item(String name, int quantity, double price) {

        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {

        return name + ", " + quantity + "×, " + price + "$";
    }

    @Override
    public int compareTo(Item o) {

        return Double.compare(this.price, o.price);
    }
}

class ComparatorByPrice implements Comparator<Item> {

    @Override
    public int compare(Item o1, Item o2) {

        return 0;
    }
}