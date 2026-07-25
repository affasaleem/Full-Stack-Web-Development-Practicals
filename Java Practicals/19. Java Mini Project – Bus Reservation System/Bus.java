/**
 * Bus.java
 * Represents a single bus in the Bus Reservation System.
 * Holds the bus's identity, route information and seating details.
 */
public class Bus {

    private String busId;          // Unique identifier for the bus (e.g. B001)
    private String busName;        // Name / operator of the bus
    private String route;          // Route information, e.g. "Colombo - Kandy"
    private int totalSeats;        // Total seating capacity of the bus
    private int availableSeats;    // Seats currently available for booking
    private double ticketPrice;    // Price per seat

    public Bus(String busId, String busName, String route, int totalSeats, double ticketPrice) {
        this.busId = busId;
        this.busName = busName;
        this.route = route;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats; // initially all seats are free
        this.ticketPrice = ticketPrice;
    }

    // ---------- Getters ----------
    public String getBusId() {
        return busId;
    }

    public String getBusName() {
        return busName;
    }

    public String getRoute() {
        return route;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    // ---------- Setters / behaviour ----------

    /**
     * Updates the total seating capacity of the bus.
     * Available seats are adjusted so that the number of already
     * booked seats remains consistent.
     */
    public void updateCapacity(int newCapacity) {
        int bookedSeats = totalSeats - availableSeats;
        this.totalSeats = newCapacity;
        this.availableSeats = newCapacity - bookedSeats;
        if (this.availableSeats < 0) {
            this.availableSeats = 0;
        }
    }

    /**
     * Attempts to reserve one seat.
     * @return true if a seat was successfully reserved, false if the bus is full.
     */
    public boolean reserveSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        }
        return false;
    }

    /**
     * Releases one previously booked seat back into the available pool.
     */
    public void releaseSeat() {
        if (availableSeats < totalSeats) {
            availableSeats++;
        }
    }

    /**
     * Returns a nicely formatted single line describing the bus.
     */
    public String toDisplayString() {
        return String.format(
                "%-8s %-15s %-20s %-8d %-10d Rs. %-10.2f",
                busId, busName, route, totalSeats, availableSeats, ticketPrice
        );
    }

    @Override
    public String toString() {
        return toDisplayString();
    }
}
