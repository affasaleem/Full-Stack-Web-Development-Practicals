/*
 * Bus.java
 * Represents a single bus in the reservation system.
 */
public class Bus {

    private String busNumber;
    private String source;
    private String destination;
    private int capacity;
    private int bookedSeats;

    public Bus(String busNumber, String source, String destination, int capacity) {
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
        this.capacity = capacity;
        this.bookedSeats = 0;
    }

    public String getBusNumber() {
        return busNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public int getAvailableSeats() {
        return capacity - bookedSeats;
    }

    // Returns true if a seat was successfully booked
    public boolean bookSeat() {
        if (bookedSeats < capacity) {
            bookedSeats++;
            return true;
        }
        return false;
    }

    // Called when a booking on this bus is cancelled
    public void releaseSeat() {
        if (bookedSeats > 0) {
            bookedSeats--;
        }
    }

    @Override
    public String toString() {
        return String.format("Bus No: %-8s | %-12s -> %-12s | Capacity: %-4d | Booked: %-4d | Available: %-4d",
                busNumber, source, destination, capacity, bookedSeats, getAvailableSeats());
    }
}
