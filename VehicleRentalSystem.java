// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        Vehicle vehicles[] = new Vehicle[3];
        vehicles[0] = new Car("CAR123", 1000);
        vehicles[1] = new Bike("BIKE456", 500);
        vehicles[2] = new Truck("TRUCK789", 2000);

        int rentalDays = 5;
        for (int i = 0; i < vehicles.length; i++) {
            processRental(vehicles[i], rentalDays);
        }
    }
    //display
    public static void processRental(Vehicle vehicle, int days) {
        double rentalCost = vehicle.calculateRentalCost(days);
        double insuranceCost = vehicle.calculateInsurance();

        vehicle.displayDetails();
        System.out.println("Rental Cost for " + days + " days: $" + rentalCost);
        System.out.println("Insurance Cost: $" + insuranceCost);
    }
}

// Interface
interface Insurable {
    double calculateInsurance();
}

// Abstract class
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Abstract method
    abstract double calculateRentalCost(int days);

    public double getRentalRate() {
        return rentalRate;
    }

    // Display vehicle details
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber + ", Type: " + type);
    }
}

// Subclass
class Car extends Vehicle {
    Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of rental rate
    }
}

// Subclass: Bike
class Bike extends Vehicle {
    Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return days * getRentalRate();
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate
    }
}

// Subclass: Truck
class Truck extends Vehicle {
    Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
    }

    @Override
    double calculateRentalCost(int days) {
        return days * getRentalRate() ;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rental rate
    }
}
/*Vehicle Number: CAR123, Type: Car
Rental Cost for 5 days: $5000.0
Insurance Cost: $100.0
Vehicle Number: BIKE456, Type: Bike
Rental Cost for 5 days: $2500.0
Insurance Cost: $25.0
Vehicle Number: TRUCK789, Type: Truck
Rental Cost for 5 days: $10000.0
Insurance Cost: $300.0

 */