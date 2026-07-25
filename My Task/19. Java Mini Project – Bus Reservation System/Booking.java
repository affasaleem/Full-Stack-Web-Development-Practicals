/**
 * Booking.java
 * Represents a single passenger's ticket booking on a bus.
 */
public class Booking {

    private String bookingId;      // Unique identifier for the booking (e.g. BK001)
    private String passengerName;  // Name of the passenger
    private String busId;          // Reference to the booked bus's unique id
    private int seatsBooked;       // Number of seats booked in this reservation
    private double totalFare;      // Total fare paid for this booking

    public Booking(String bookingId, String passengerName, String busId,
                    int seatsBooked, double totalFare) {
        this.bookingId = bookingId;
        this.passengerName = passengerName;
        this.busId = busId;
        this.seatsBooked = seatsBooked;
        this.totalFare = totalFare;
    }

    // ---------- Getters ----------
    public String getBookingId() {
        return bookingId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public String getBusId() {
        return busId;
    }

    public int getSeatsBooked() {
        return seatsBooked;
    }

    public double getTotalFare() {
        return totalFare;
    }

    /**
     * Returns a nicely formatted single line describing the booking.
     */
    public String toDisplayString() {
        return String.format(
                "%-10s %-15s %-8s %-8d Rs. %-10.2f",
                bookingId, passengerName, busId, seatsBooked, totalFare
        );
    }

    @Override
    public String toString() {
        return toDisplayString();
    }
}
