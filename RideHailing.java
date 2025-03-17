// Main class
public class RideHailing {
    public static void main(String[] args) {
        Vehicles car = new Cars(101, "John", 15);
        Vehicles bike = new Bikes(102, "Mike", 8);
        Vehicles auto = new Auto(103, "Sam", 10);

        processRide(car, 10);
        processRide(bike, 5);
        processRide(auto, 7);
    }

    public static void processRide(Vehicles vehicle, double distance) {
        vehicle.getVehicleDetails();
        System.out.println("Total Fare for " + distance + " km: $" + vehicle.calculateFare(distance));
        System.out.println("---------------------------------");
    }
}

// Abstract class: Vehicle
abstract class Vehicles {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicles(int vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: $" + ratePerKm);
    }

    public abstract double calculateFare(double distance);

    public double getRatePerKm() {
        return ratePerKm;
    }
}

// Interface: GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Subclass: Car
class Cars extends Vehicles implements GPS {
    private String location;

    public Cars(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Subclass: Bike
class Bikes extends Vehicles implements GPS {
    private String location;

    public Bikes(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}

// Subclass: Auto
class Auto extends Vehicles implements GPS {
    private String location;

    public Auto(int vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.location = "Unknown";
    }

    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    public String getCurrentLocation() {
        return location;
    }

    public void updateLocation(String newLocation) {
        this.location = newLocation;
    }
}
/*Vehicle ID: 101, Driver: John, Rate per Km: $15.0
Total Fare for 10.0 km: $150.0
---------------------------------
Vehicle ID: 102, Driver: Mike, Rate per Km: $8.0
Total Fare for 5.0 km: $40.0
---------------------------------
Vehicle ID: 103, Driver: Sam, Rate per Km: $10.0
Total Fare for 7.0 km: $70.0
---------------------------------
 */