// Main class
public class FoodDelivery {
    public static void main(String[] args) {
        FoodItem veg = new VegItem("Paneer", 200, 2);
        FoodItem nonVeg = new NonVegItem("Chicken", 350, 1);

        // Process and display order details using polymorphism
        processOrder(veg);
        processOrder(nonVeg);
    }

    public static void processOrder(FoodItem item) {
        item.getItemDetails();
        System.out.println("Total Price: $" + item.calculateTotalPrice());
        System.out.println(((Discountable) item).getDiscountDetails());
        System.out.println("---------------------------------");
    }
}

// Abstract class: FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: $" + price + ", Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

// Interface: Discountable
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Subclass: VegItem
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double total = getPrice() * getQuantity();
        return total - applyDiscount();
    }

    public double applyDiscount() {
        return getPrice() * getQuantity() * 0.05; // 5% discount on veg items
    }

    public String getDiscountDetails() {
        return "5% discount on Veg items";
    }
}
// Subclass: NonVegItem
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    public double calculateTotalPrice() {
        double total = (getPrice() * getQuantity());
        return total - applyDiscount();
    }

    public double applyDiscount() {
        return getPrice() * getQuantity() * 0.03; // 3% discount on non-veg items
    }

    public String getDiscountDetails() {
        return "3% discount on Non-Veg items";
    }
}
/*Item: Paneer, Price: $200.0, Quantity: 2
Total Price: $380.0
5% discount on Veg items
---------------------------------
Item: Chicken, Price: $350.0, Quantity: 1
Total Price: $339.5
3% discount on Non-Veg items
 */