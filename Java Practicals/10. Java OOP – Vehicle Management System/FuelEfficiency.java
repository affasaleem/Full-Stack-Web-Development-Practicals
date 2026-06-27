/**
 * FuelEfficiency.java
 *
 * Interface that defines a contract for any vehicle that can
 * calculate its fuel mileage. Any class that implements this
 * interface guarantees it will provide its own calculateMileage()
 * logic. This allows different, unrelated classes (Car, Bike, or
 * even future classes like Truck) to share fuel-efficiency behavior
 * without needing to belong to the same class hierarchy.
 */
public interface FuelEfficiency {

    /**
     * Calculates and returns the mileage (distance per unit of fuel)
     * for the implementing vehicle.
     *
     * @return the calculated mileage value
     */
    double calculateMileage();
}
