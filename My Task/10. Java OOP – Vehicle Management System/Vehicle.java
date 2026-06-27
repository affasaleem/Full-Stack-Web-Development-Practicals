/**
 * Vehicle.java
 *
 * Abstract class representing a generic vehicle.
 *
 * This class defines the common structure that every vehicle must
 * follow (it has a name and can start/stop), but it does NOT know
 * HOW a specific vehicle starts or stops — that behavior is left
 * to the subclasses through abstract methods. This is an example
 * of abstraction: we describe WHAT a vehicle can do, not HOW.
 */
public abstract class Vehicle {

    // ---------- Common Field ----------
    protected String vehicleName;

    /**
     * Constructor to initialize the common vehicle name field.
     *
     * @param vehicleName the name/model of the vehicle
     */
    public Vehicle(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    /**
     * Abstract method to start the vehicle.
     * Every subclass MUST provide its own implementation,
     * since starting a car is different from starting a bike.
     */
    public abstract void start();

    /**
     * Abstract method to stop the vehicle.
     * Every subclass MUST provide its own implementation.
     */
    public abstract void stop();
}
