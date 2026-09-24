package oop;

import fileworks.DataImport;

import java.util.ArrayList;

class Product {
    private String name;
    private String productCategory;
    private int amount;
    private double pricePerPiece;

    private final String DEFAULT_CATEGORY = "Other";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (amount >= 0) {
            this.amount = amount;
        } else {
            this.amount = 0;
        }
    }

    public double getPricePerPiece() {
        return pricePerPiece;
    }

    public void setPricePerPiece(double pricePerPiece) {
        if (pricePerPiece > 0) {
            this.pricePerPiece = pricePerPiece;
        } else {
            this.pricePerPiece = 0;
        }
    }

    public Product(String name, String productCategory) {
        this.name = name;
        this.productCategory = productCategory;
    }

    public Product(String name, String productCategory, int amount) {
        this(name, productCategory);
        this.amount = amount;
    }

//    public Product(String name, int amount, double pricePerPiece){

    /// /        this(name, DEFAULT_CATEGORY, amount, pricePerPiece);
//        this.name = name;
//        this.category = DEFAULT_CATEGORY;
//        this.amount = amount;
//        this.pricePerPiece = pricePerPiece;
//    }
    public Product(String name, String productCategory, int amount, double pricePerPiece) {
        this(name, productCategory, amount);
        this.pricePerPiece = pricePerPiece;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + productCategory + '\'' +
                ", amount=" + amount +
                ", pricePerPiece=" + pricePerPiece +
                '}';
    }
}

public class Products {
    public static void main(String[] args) {
        // načíst celý soubor a vypsat počet kusů na skladu
        DataImport di = new DataImport("data/products.txt");

        String line;
        ArrayList<Product> products = new ArrayList<>();
        String[] params;
        Product product;
        while (di.hasNext()) {
            line = di.readLine();
            params = line.split(";");

//            if (params.length == 4) System.out.println("neco");
//            if (params.length == 3) System.out.println("neco");
//            if (params.length == 2) System.out.println("neco");

            switch (params.length){
                case 4: product = new Product(params[0], params[1], Integer.parseInt(params[2]), Double.parseDouble(params[3]));
                    break;
                case 3: product = new Product(params[0], params[1], Integer.parseInt(params[2]));
                    break;
                case 2: product = new Product(params[0], params[1]);
                    break;
                default:
                    System.out.println("Tento radek nema validni delku: " + line);
                    product = null;
                    break;
            }
            products.add(product);
            System.out.println(line);
        }


        di.finishImport();

//      ukazka zakomentovaneho konstruktoru + null pointer exception
//        Product product = new Product("Chair", 400, 465);

//        System.out.println(product.getName() + ": "+ product.getAmount());
//        System.out.println(product.toString());
//        product.getCategory().toUpperCase();
//        product.getName();
//        product.name;


    }
}
