package oop;

class Product {
    private String name;
    private String category;
    private int amount;
    private double pricePerPiece;

    private final String DEFAULT_CATEGORY = "Other";

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
        if(pricePerPiece > 0){
            this.pricePerPiece = pricePerPiece;
        }
        else {
            this.pricePerPiece = 0;
        }
    }

    public Product(String name, String category) {
        this.name = name;
        this.category = category;
    }

    public Product(String name, String category, int amount) {
        this(name, category);
        this.amount = amount;
    }

    public Product(String name, int amount, int pricePerPiece){
//        this(name, DEFAULT_CATEGORY, amount, pricePerPiece);
        this.name = name;
        this.category = DEFAULT_CATEGORY;
        this.amount = amount;
        this.pricePerPiece = pricePerPiece;
    }

    public Product(String name, String category, int amount, int pricePerPiece) {
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
    // načíst celý soubor a vypsat počet kusů na skladu
        Product product = new Product("Chair", 400, 465);

        System.out.println(product.getName() + ": "+ product.getAmount());
        System.out.println(product.toString());
        product.getCategory().toUpperCase();
//        product.getName();
//        product.name;


    }
}
