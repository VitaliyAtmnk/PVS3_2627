package student.oop;

import fileworks.DataImport;

import java.util.ArrayList;

public class Product {
    private String name;
    private String category;
    private int amount;
    private double pricePerPiece;

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
        this.amount = amount;
    }

    public double getPricePerPiece() {
        return  pricePerPiece;
    }

    public void setPricePerPiece(int pricePerPiece) {
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

    public static void main(String[] args) {
        DataImport di = new DataImport("data/products.txt");

        ArrayList<Product> all = new ArrayList<>();
        while (di.hasNext()) {
            String line = di.readLine();
            String[] tokens = line.split(";");


            String name = tokens[0];
            String category = (tokens[1]);
            int amount;
            double pricePerPiece;

            if (tokens.length == 3) {
                amount = Integer.parseInt(tokens[2]);
                Product holder = new Product(
                        name,
                        category,
                        amount
                );
            }
            else if (tokens.length == 4) {
                amount = Integer.parseInt(tokens[2]);
                pricePerPiece = Double.parseDouble(tokens[3]);
                Product holder = new Product(
                        name,
                        category,
                        amount,
                        pricePerPiece
                );
            }
            else {Product holder = new Product(
                    name,
                    category
            );
            }



        }
    }

}

