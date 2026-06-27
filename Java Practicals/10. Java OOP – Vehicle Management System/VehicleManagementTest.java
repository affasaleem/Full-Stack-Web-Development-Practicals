/**
 * VehicleManagementTest.java
 *
 * Main class used to demonstrate the Vehicle Management System.
 * Creates a Car object and a Bike object, then calls start(),
 * stop(), and calculateMileage() on each to show that both classes
 * correctly implement the abstract Vehicle methods and the
 * FuelEfficiency interface method with their own logic.
 */
public class VehicleManagementTest {

    public static void main(String[] args) {

        // ----- Create and test a Car object -----
        Car myCar = new Car("Toyota Corolla", 450, 30);

        System.out.println("===== Car Operations =====");
        myCar.start();
        myCar.stop();
        System.out.println("Car Mileage: " + myCar.calculateMileage() + " km/l");

        // ----- Create and test a Bike object -----
        Bike myBike = new Bike("Honda CB150", 300, 6);

        System.out.println("\n===== Bike Operations =====");
        myBike.start();
        myBike.stop();
        System.out.println("Bike Mileage: " + myBike.calculateMileage() + " km/l");
    }
}
