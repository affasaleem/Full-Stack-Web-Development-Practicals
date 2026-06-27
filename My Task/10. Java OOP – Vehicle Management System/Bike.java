/**
 * Bike.java
 *
 * Concrete class that extends the abstract Vehicle class and
 * implements the FuelEfficiency interface. It provides its own
 * specific implementation for start(), stop(), and
 * calculateMileage(), independent of how Car implements the
 * same methods.
 */
public class Bike extends Vehicle implements FuelEfficiency {

    // ---------- Fields specific to Bike ----------
    private double distanceTravelledKm;
    private double fuelUsedLitres;

    /**
     * Constructor that initializes the inherited vehicleName field
     * via super(), plus the distance and fuel data needed to
     * calculate mileage.
     *
     * @param vehicleName         the name/model of the bike
     * @param distanceTravelledKm distance travelled in kilometers
     * @param fuelUsedLitres      fuel consumed in litres for that distance
     */
    public Bike(String vehicleName, double distanceTravelledKm, double fuelUsedLitres) {
        super(vehicleName);
        this.distanceTravelledKm = distanceTravelledKm;
        this.fuelUsedLitres = fuelUsedLitres;
    }

    /**
     * Implements the abstract start() method from Vehicle
     * with bike-specific behavior.
     */
    @Override
    public void start() {
        System.out.println(vehicleName + " (Bike): Kick-started and ready to ride.");
    }

    /**
     * Implements the abstract stop() method from Vehicle
     * with bike-specific behavior.
     */
    @Override
    public void stop() {
        System.out.println(vehicleName + " (Bike): Engine switched off.");
    }

    /**
     * Implements calculateMileage() from the FuelEfficiency
     * interface. Mileage is calculated as distance travelled
     * divided by fuel used.
     *
     * @return mileage in kilometers per litre
     */
    @Override
    public double calculateMileage() {
        if (fuelUsedLitres <= 0) {
            System.out.println(vehicleName + " (Bike): Cannot calculate mileage, fuel used is zero.");
            return 0;
        }
        return distanceTravelledKm / fuelUsedLitres;
    }
}
