package oop;

import fileworks.DataImport;

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
        if(amount >= 0) this.amount = amount;
        else this.amount = 0;
    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(double pricePerPiece) {
        if(pricePerPiece > 0) this.pricePerPiece = pricePerPiece;
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
        while(di.hasNext()) {
            String[] tokens = di.readLine().split(";");
            Product product = new Product(tokens[0], tokens[1], 0, 0.0);
            if (tokens.length == 3) {
                product.setAmount(Integer.parseInt(tokens[2]));
            } else {
                product.setAmount(Integer.parseInt(tokens[2]));
                product.setPricePerPiece(Double.parseDouble(tokens[3]));
            }
            System.out.println(product.toString());
        }
        di.finishImport();
    }
}
