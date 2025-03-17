// Main class
public class EcommercePlatform {
    public static void main(String[] args) {
        Product product1 = new Electronics(101, "Laptop", 80000);
        Product product2 = new Clothing(102, "T-Shirt", 1500);
        Product product3 = new Groceries(103, "Rice", 500);
        processProduct(product1);
        processProduct(product2);
        processProduct(product3);
    }

    // Polymorphism
    public static void processProduct(Product product) {
        double tax = product.calculateTax();
        double discount = product.calculateDiscount();
        double finalPrice = product.getPrice() + tax - discount;

        product.displayDetails();
        System.out.println("Tax: $" + tax + ", Discount: $" + discount + ", Final Price: $" + finalPrice);
    }
}

// Abstract class
abstract class Product implements Taxable {
    private int productId;
    private String name;
    private double price;

    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("Product ID: " + productId + ", Name: " + name + ", Price: $" + price);
    }

    public double getPrice() {
        return price;
    }
}

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
// Subclass
class Electronics extends Product {
    Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% tax
    }

    @Override
    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}

// Subclass
class Clothing extends Product {
    Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% tax
    }

    @Override
    public String getTaxDetails() {
        return "12% GST on Clothing";
    }
}

// Subclass
class Groceries extends Product {
    Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    double calculateDiscount() {
        return getPrice() * 0.02; // 2% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% tax
    }

    @Override
    public String getTaxDetails() {
        return "5% GST on Groceries";
    }
}
/*roduct ID: 101, Name: Laptop, Price: $80000.0
Tax: $14400.0, Discount: $8000.0, Final Price: $86400.0
Product ID: 102, Name: T-Shirt, Price: $1500.0
Tax: $180.0, Discount: $75.0, Final Price: $1605.0
Product ID: 103, Name: Rice, Price: $500.0
Tax: $25.0, Discount: $10.0, Final Price: $515.0
 */