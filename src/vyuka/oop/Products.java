package vyuka.oop;

import fileworks.DataImport;

import java.util.ArrayList;

class Product {
    private String name;
    private String category;
    private int amount;
    private double pricePerPiece;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount >= 0) this.amount = amount;
        else this.amount = 0;
    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(double pricePerPiece) {
        if (pricePerPiece > 0) this.pricePerPiece = pricePerPiece;
        else this.pricePerPiece = 0;
    }

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Product(String name, String category, int amount) {
        this(name, category);
        this.amount = amount;
    }

    public Product(String name, String category, int amount, double pricePerPiece) {
        this(name, category, amount);
        this.pricePerPiece = pricePerPiece;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", pricePerPiece=" + pricePerPiece +
                '}';
    }
}

public class Products {
    public static void main(String[] args) {
        DataImport di = new DataImport("data/products.txt");

        String line;
        ArrayList<Product> products = new ArrayList<>();
        String[] params;
        Product product = null;
        while (di.hasNext()) {
            line = di.readLine();
            params = line.split(";");
//            if(params.length == 4) System.out.println("neco");
//            if(params.length == 3) System.out.println("neco");
//            if(params.length == 2) System.out.println("neco");
            switch (params.length) {
                case 4: product = new Product(params[0], params[1], Integer.parseInt(params[2]), Double.parseDouble(params[3]));
                    break;
                case 3: product = new Product(params[0], params[1], Integer.parseInt(params[2]));
                    break;
                case 2: product = new Product(params[0], params[1]);
                    break;
                default:
                    System.out.println("Tento řádek nemá validní délku: " + line);
            }
            products.add(product);
        }

        di.finishImport();
    }
}
