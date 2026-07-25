import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * BusReservationSystem.java
 *
 * Menu-driven console application for managing buses and passenger bookings.
 *
 * Data structures used:
 *  - buses:    HashMap<busNumber, Bus>       -> fast lookup/update/delete by bus number
 *  - bookings: HashMap<passengerId, Booking> -> fast lookup and guarantees unique passenger IDs
 */
public class BusReservationSystem {

    private final Map<String, Bus> buses = new HashMap<>();
    private final Map<String, Booking> bookings = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BusReservationSystem system = new BusReservationSystem();
        system.run();
    }

    // Main application loop
    private void run() {
        boolean running = true;
        System.out.println("=================================================");
        System.out.println(" WELCOME TO THE BUS RESERVATION SYSTEM");
        System.out.println("=================================================");

        while (running) {
            printMainMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addBus();
                case 2 -> viewAllBuses();
                case 3 -> updateBusCapacity();
                case 4 -> deleteBus();
                case 5 -> searchBus();
                case 6 -> bookTicket();
                case 7 -> viewAllBookings();
                case 8 -> cancelBooking();
                case 9 -> {
                    running = false;
                    System.out.println("Thank you for using the Bus Reservation System. Goodbye!");
                }
                default -> System.out.println("Invalid choice. Please select a number between 1 and 9.");
            }
            System.out.println(); // spacing between menu cycles
        }
        scanner.close();
    }

    private void printMainMenu() {
        System.out.println("-------------------------------------------------");
        System.out.println("               MAIN MENU");
        System.out.println("-------------------------------------------------");
        System.out.println(" 1. Add a new bus");
        System.out.println(" 2. View all available buses");
        System.out.println(" 3. Update bus capacity");
        System.out.println(" 4. Delete a bus");
        System.out.println(" 5. Search for a bus by bus number");
        System.out.println(" 6. Book a ticket");
        System.out.println(" 7. View all bookings");
        System.out.println(" 8. Cancel a booking");
        System.out.println(" 9. Exit");
        System.out.println("-------------------------------------------------");
    }

    // ---------------------------------------------------------------
    // Module 01 - Bus Management
    // ---------------------------------------------------------------

    private void addBus() {
        System.out.println("\n--- Add a New Bus ---");
        String busNumber = readNonEmptyString("Enter bus number: ");

        if (buses.containsKey(busNumber)) {
            System.out.println("Error: A bus with number '" + busNumber + "' already exists.");
            return;
        }

        String source = readNonEmptyString("Enter source: ");
        String destination = readNonEmptyString("Enter destination: ");
        int capacity = readPositiveInt("Enter bus capacity: ");

        Bus bus = new Bus(busNumber, source, destination, capacity);
        buses.put(busNumber, bus);

        System.out.println("Success: Bus '" + busNumber + "' has been added.");
    }

    private void viewAllBuses() {
        System.out.println("\n--- All Available Buses ---");
        if (buses.isEmpty()) {
            System.out.println("No buses have been added yet.");
            return;
        }
        for (Bus bus : buses.values()) {
            System.out.println(bus);
        }
    }

    private void updateBusCapacity() {
        System.out.println("\n--- Update Bus Capacity ---");
        String busNumber = readNonEmptyString("Enter bus number: ");
        Bus bus = buses.get(busNumber);

        if (bus == null) {
            System.out.println("Error: No bus found with number '" + busNumber + "'.");
            return;
        }

        if (bus.getBookedSeats() > 0) {
            System.out.println("Current booked seats: " + bus.getBookedSeats());
        }

        int newCapacity = readInt("Enter new capacity: ");
        if (newCapacity < bus.getBookedSeats()) {
            System.out.println("Error: New capacity (" + newCapacity
                    + ") cannot be less than the already booked seats (" + bus.getBookedSeats() + ").");
            return;
        }

        bus.setCapacity(newCapacity);
        System.out.println("Success: Capacity for bus '" + busNumber + "' updated to " + newCapacity + ".");
    }

    private void deleteBus() {
        System.out.println("\n--- Delete a Bus ---");
        String busNumber = readNonEmptyString("Enter bus number: ");

        if (!buses.containsKey(busNumber)) {
            System.out.println("Error: No bus found with number '" + busNumber + "'.");
            return;
        }

        buses.remove(busNumber);
        System.out.println("Success: Bus '" + busNumber + "' has been deleted.");
        System.out.println("Note: Any existing bookings for this bus were kept in booking history.");
    }

    private void searchBus() {
        System.out.println("\n--- Search for a Bus ---");
        String busNumber = readNonEmptyString("Enter bus number: ");
        Bus bus = buses.get(busNumber);

        if (bus == null) {
            System.out.println("No bus found with number '" + busNumber + "'.");
        } else {
            System.out.println("Bus found:");
            System.out.println(bus);
        }
    }

    // ---------------------------------------------------------------
    // Module 02 - Ticket Booking
    // ---------------------------------------------------------------

    private void bookTicket() {
        System.out.println("\n--- Book a Ticket ---");

        if (buses.isEmpty()) {
            System.out.println("No buses are available for booking yet.");
            return;
        }

        String passengerId = readNonEmptyString("Enter passenger ID: ");
        if (bookings.containsKey(passengerId)) {
            System.out.println("Error: Passenger ID '" + passengerId + "' is already in use. Passenger IDs must be unique.");
            return;
        }

        String passengerName = readNonEmptyString("Enter passenger name: ");
        String busNumber = readNonEmptyString("Enter bus number: ");

        Bus bus = buses.get(busNumber);
        if (bus == null) {
            System.out.println("Error: No bus found with number '" + busNumber + "'.");
            return;
        }

        if (bus.getAvailableSeats() <= 0) {
            System.out.println("Sorry, bus '" + busNumber + "' is fully booked. No seats available.");
            return;
        }

        bus.bookSeat();
        Booking booking = new Booking(passengerId, passengerName, busNumber, bus.getSource(), bus.getDestination());
        bookings.put(passengerId, booking);

        System.out.println("Success: Seat booked for " + passengerName + " (Passenger ID: " + passengerId + ") on bus '" + busNumber + "'.");
        System.out.println("Remaining seats on bus '" + busNumber + "': " + bus.getAvailableSeats());
    }

    // ---------------------------------------------------------------
    // Module 03 - View Bookings
    // ---------------------------------------------------------------

    private void viewAllBookings() {
        System.out.println("\n--- All Bookings ---");
        if (bookings.isEmpty()) {
            System.out.println("No bookings have been made yet.");
            return;
        }
        for (Booking booking : bookings.values()) {
            System.out.println(booking);
        }
    }

    // ---------------------------------------------------------------
    // Module 04 - Cancel Booking
    // ---------------------------------------------------------------

    private void cancelBooking() {
        System.out.println("\n--- Cancel a Booking ---");
        String passengerId = readNonEmptyString("Enter passenger ID: ");

        Booking booking = bookings.get(passengerId);
        if (booking == null) {
            System.out.println("Error: No booking found for passenger ID '" + passengerId + "'.");
            return;
        }

        Bus bus = buses.get(booking.getBusNumber());
        if (bus != null) {
            bus.releaseSeat();
        }

        bookings.remove(passengerId);
        System.out.println("Success: Booking for passenger '" + booking.getPassengerName()
                + "' (ID: " + passengerId + ") has been cancelled.");
    }

    // ---------------------------------------------------------------
    // Input helper methods (validate user input)
    // ---------------------------------------------------------------

    private String readNonEmptyString(String prompt) {
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

    private int readInt(String prompt) {
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

    private int readPositiveInt(String prompt) {
        while (true) {
            int value = readInt(prompt);
            if (value > 0) {
                return value;
            }
            System.out.println("Please enter a number greater than 0.");
        }
    }
}
