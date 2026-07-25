import java.util.ArrayList;
import java.util.List;

/**
 * BookingManager.java
 * Handles all operations related to passenger bookings:
 * booking tickets, viewing bookings and cancelling bookings.
 */
public class BookingManager {

    private List<Booking> bookings;
    private int bookingCounter; // used to auto-generate unique booking ids

    public BookingManager() {
        this.bookings = new ArrayList<>();
        this.bookingCounter = 1;
    }

    /**
     * Books a seat for a passenger on the given bus, provided a seat is available.
     * @return the created Booking if successful, or null if the bus has no available seats.
     */
    public Booking bookTicket(Bus bus, String passengerName, int seatsRequested) {
        // Validate seat availability before confirming the booking.
        if (seatsRequested <= 0 || bus.getAvailableSeats() < seatsRequested) {
            return null;
        }

        // Reserve the requested number of seats one at a time.
        for (int i = 0; i < seatsRequested; i++) {
            bus.reserveSeat();
        }

        String bookingId = String.format("BK%03d", bookingCounter++);
        double totalFare = bus.getTicketPrice() * seatsRequested;

        Booking booking = new Booking(bookingId, passengerName, bus.getBusId(), seatsRequested, totalFare);
        bookings.add(booking);
        return booking;
    }

    /**
     * Displays details of all bookings currently stored in the system.
     */
    public void viewAllBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings found in the system.");
            return;
        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("%-10s %-15s %-8s %-8s %-10s%n",
                "Booking ID", "Passenger", "Bus ID", "Seats", "Fare");
        System.out.println("--------------------------------------------------------------------------");

        for (Booking booking : bookings) {
            System.out.println(booking.toDisplayString());
        }
        System.out.println("--------------------------------------------------------------------------");
    }

    /**
     * Finds a booking by its unique identifier.
     * @return the matching Booking, or null if not found.
     */
    public Booking findBookingById(String bookingId) {
        for (Booking booking : bookings) {
            if (booking.getBookingId().equalsIgnoreCase(bookingId)) {
                return booking;
            }
        }
        return null;
    }

    /**
     * Cancels an existing booking and releases its seats back to the given bus.
     * @return true if the booking was found and cancelled, false otherwise.
     */
    public boolean cancelBooking(String bookingId, Bus bus) {
        Booking booking = findBookingById(bookingId);
        if (booking == null) {
            return false;
        }

        // Update the available seat count after cancellation.
        for (int i = 0; i < booking.getSeatsBooked(); i++) {
            bus.releaseSeat();
        }

        bookings.remove(booking);
        return true;
    }
}
