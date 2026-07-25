import java.util.Scanner;

/**
 * BusReservationSystem.java
 * Main entry point of the application.
 * Implements a menu-driven console application that lets the user
 * manage buses and passenger bookings.
 */
public class BusReservationSystem {

    private static final Scanner scanner = new Scanner(System.in);
    private static final BusManager busManager = new BusManager();
    private static final BookingManager bookingManager = new BookingManager();

    public static void main(String[] args) {
        System.out.println("=====================================================");
        System.out.println("      WELCOME TO THE BUS RESERVATION SYSTEM");
        System.out.println("=====================================================");

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1:
                    addBus();
                    break;
                case 2:
                    viewAllBuses();
                    break;
                case 3:
                    updateBusCapacity();
                    break;
                case 4:
                    deleteBus();
                    break;
                case 5:
                    bookTicket();
                    break;
                case 6:
                    viewAllBookings();
                    break;
                case 7:
                    cancelBooking();
                    break;
                case 8:
                    running = false;
                    System.out.println("Thank you for using the Bus Reservation System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select an option between 1 and 8.");
            }
            System.out.println(); // blank line for readability between menu cycles
        }

        scanner.close();
    }

    /**
     * Prints the main menu options to the console.
     */
    private static void printMenu() {
        System.out.println("-----------------------------------------------------");
        System.out.println("1. Add Bus");
        System.out.println("2. View All Buses");
        System.out.println("3. Update Bus Capacity");
        System.out.println("4. Delete Bus");
        System.out.println("5. Book Ticket");
        System.out.println("6. View All Bookings");
        System.out.println("7. Cancel Booking");
        System.out.println("8. Exit");
        System.out.println("-----------------------------------------------------");
    }

    // -------------------- Bus Management --------------------

    private static void addBus() {
        System.out.println("\n--- Add New Bus ---");
        String busId = readNonEmptyString("Enter Bus ID (e.g. B001): ");

        if (busManager.findBusById(busId) != null) {
            System.out.println("Error: A bus with ID '" + busId + "' already exists.");
            return;
        }

        String busName = readNonEmptyString("Enter Bus Name: ");
        String route = readNonEmptyString("Enter Route (e.g. Colombo - Kandy): ");
        int totalSeats = readPositiveInt("Enter Total Seats: ");
        double ticketPrice = readPositiveDouble("Enter Ticket Price (Rs.): ");

        Bus bus = new Bus(busId, busName, route, totalSeats, ticketPrice);
        boolean added = busManager.addBus(bus);

        if (added) {
            System.out.println("Success: Bus '" + busId + "' has been added.");
        } else {
            System.out.println("Error: Could not add bus. A bus with this ID already exists.");
        }
    }

    private static void viewAllBuses() {
        System.out.println("\n--- All Buses ---");
        busManager.viewAllBuses();
    }

    private static void updateBusCapacity() {
        System.out.println("\n--- Update Bus Capacity ---");
        if (busManager.isEmpty()) {
            System.out.println("No buses available to update.");
            return;
        }

        String busId = readNonEmptyString("Enter Bus ID to update: ");
        Bus bus = busManager.findBusById(busId);

        if (bus == null) {
            System.out.println("Error: No bus found with ID '" + busId + "'.");
            return;
        }

        int newCapacity = readPositiveInt("Enter new total seating capacity: ");
        boolean updated = busManager.updateBusCapacity(busId, newCapacity);

        if (updated) {
            System.out.println("Success: Capacity for bus '" + busId + "' updated to " + newCapacity + ".");
        } else {
            System.out.println("Error: Could not update bus capacity.");
        }
    }

    private static void deleteBus() {
        System.out.println("\n--- Delete Bus ---");
        if (busManager.isEmpty()) {
            System.out.println("No buses available to delete.");
            return;
        }

        String busId = readNonEmptyString("Enter Bus ID to delete: ");
        boolean deleted = busManager.deleteBus(busId);

        if (deleted) {
            System.out.println("Success: Bus '" + busId + "' has been removed from the system.");
        } else {
            System.out.println("Error: No bus found with ID '" + busId + "'.");
        }
    }

    // -------------------- Booking Management --------------------

    private static void bookTicket() {
        System.out.println("\n--- Book Ticket ---");
        if (busManager.isEmpty()) {
            System.out.println("No buses available for booking.");
            return;
        }

        busManager.viewAllBuses();
        String busId = readNonEmptyString("Enter Bus ID to book: ");
        Bus bus = busManager.findBusById(busId);

        if (bus == null) {
            System.out.println("Error: No bus found with ID '" + busId + "'.");
            return;
        }

        if (bus.getAvailableSeats() <= 0) {
            System.out.println("Sorry, bus '" + busId + "' is fully booked.");
            return;
        }

        String passengerName = readNonEmptyString("Enter Passenger Name: ");
        int seatsRequested = readPositiveInt("Enter Number of Seats to Book: ");

        if (seatsRequested > bus.getAvailableSeats()) {
            System.out.println("Error: Only " + bus.getAvailableSeats() +
                    " seat(s) available on this bus. Booking cancelled.");
            return;
        }

        Booking booking = bookingManager.bookTicket(bus, passengerName, seatsRequested);

        if (booking != null) {
            System.out.println("Success: Ticket booked! Booking ID: " + booking.getBookingId() +
                    ", Total Fare: Rs. " + String.format("%.2f", booking.getTotalFare()));
        } else {
            System.out.println("Error: Booking could not be completed. Not enough seats available.");
        }
    }

    private static void viewAllBookings() {
        System.out.println("\n--- All Bookings ---");
        bookingManager.viewAllBookings();
    }

    private static void cancelBooking() {
        System.out.println("\n--- Cancel Booking ---");
        String bookingId = readNonEmptyString("Enter Booking ID to cancel: ");
        Booking booking = bookingManager.findBookingById(bookingId);

        if (booking == null) {
            System.out.println("Error: No booking found with ID '" + bookingId + "'.");
            return;
        }

        Bus bus = busManager.findBusById(booking.getBusId());
        if (bus == null) {
            System.out.println("Error: Associated bus record could not be found. Cancellation aborted.");
            return;
        }

        boolean cancelled = bookingManager.cancelBooking(bookingId, bus);
        if (cancelled) {
            System.out.println("Success: Booking '" + bookingId + "' has been cancelled and seats released.");
        } else {
            System.out.println("Error: Could not cancel booking.");
        }
    }

    // -------------------- Input Helper Methods --------------------

    /**
     * Reads a non-empty string from the user, re-prompting until valid input is given.
     */
    private static String readNonEmptyString(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    /**
     * Reads an integer from the user, re-prompting on invalid (non-numeric) input.
     */
    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    /**
     * Reads a positive integer (> 0) from the user, re-prompting on invalid input.
     */
    private static int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Value must be greater than zero. Please try again.");
        }
    }

    /**
     * Reads a positive double (> 0) from the user, re-prompting on invalid input.
     */
    private static double readPositiveDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                }
                System.out.println("Value must be greater than zero. Please try again.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
