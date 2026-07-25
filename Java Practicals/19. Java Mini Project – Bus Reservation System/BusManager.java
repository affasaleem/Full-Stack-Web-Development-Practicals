import java.util.ArrayList;
import java.util.List;

/**
 * BusManager.java
 * Handles all operations related to managing buses:
 * adding, viewing, updating capacity and deleting buses.
 */
public class BusManager {

    private List<Bus> buses;

    public BusManager() {
        this.buses = new ArrayList<>();
    }

    /**
     * Adds a new bus to the system.
     * @return true if added successfully, false if a bus with the same id already exists.
     */
    public boolean addBus(Bus bus) {
        if (findBusById(bus.getBusId()) != null) {
            return false; // duplicate bus id
        }
        buses.add(bus);
        return true;
    }

    /**
     * Displays details of all buses currently stored in the system.
     */
    public void viewAllBuses() {
        if (buses.isEmpty()) {
            System.out.println("No buses available in the system.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-8s %-15s %-20s %-8s %-10s %-10s%n",
                "Bus ID", "Bus Name", "Route", "Total", "Available", "Price");
        System.out.println("--------------------------------------------------------------------------------------");

        for (Bus bus : buses) {
            System.out.println(bus.toDisplayString());
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    /**
     * Finds a bus by its unique identifier.
     * @return the matching Bus, or null if not found.
     */
    public Bus findBusById(String busId) {
        for (Bus bus : buses) {
            if (bus.getBusId().equalsIgnoreCase(busId)) {
                return bus;
            }
        }
        return null;
    }

    /**
     * Updates the seating capacity of an existing bus.
     * @return true if the bus was found and updated, false otherwise.
     */
    public boolean updateBusCapacity(String busId, int newCapacity) {
        Bus bus = findBusById(busId);
        if (bus == null) {
            return false;
        }
        bus.updateCapacity(newCapacity);
        return true;
    }

    /**
     * Removes a bus from the system using its unique identifier.
     * @return true if the bus was found and removed, false otherwise.
     */
    public boolean deleteBus(String busId) {
        Bus bus = findBusById(busId);
        if (bus == null) {
            return false;
        }
        buses.remove(bus);
        return true;
    }

    public boolean isEmpty() {
        return buses.isEmpty();
    }
}
