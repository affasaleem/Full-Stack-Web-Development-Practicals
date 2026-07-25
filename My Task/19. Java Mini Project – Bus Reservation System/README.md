# Bus Reservation System (Java Mini Project)

A menu-driven console application built in Java that manages buses and
passenger ticket bookings, following Object-Oriented Programming principles.

## Features

1. **Add Bus** – Add a new bus with ID, name, route, seating capacity and ticket price.
2. **View All Buses** – Display details of every bus in the system.
3. **Update Bus Capacity** – Change the total seat count of an existing bus.
4. **Delete Bus** – Remove a bus using its unique Bus ID.
5. **Book Ticket** – Book one or more seats for a passenger, with seat availability validation.
6. **View All Bookings** – Display all passenger bookings.
7. **Cancel Booking** – Cancel a booking and release its seats back to the bus.
8. **Exit** – Safely close the application.

## Project Structure

| File                          | Responsibility                                              |
|--------------------------------|--------------------------------------------------------------|
| `Bus.java`                     | Entity class representing a single bus                       |
| `Booking.java`                 | Entity class representing a single passenger booking         |
| `BusManager.java`               | Business logic for managing buses (add/view/update/delete)   |
| `BookingManager.java`           | Business logic for managing bookings (book/view/cancel)      |
| `BusReservationSystem.java`     | Main class with the menu-driven console UI                   |

The design follows OOP principles: each class has a single, clear
responsibility, data fields are kept private with controlled access through
methods, and the manager classes encapsulate the collections of `Bus` and
`Booking` objects.

## How to Compile and Run

Make sure you have a Java Development Kit (JDK 8+) installed, then from the
project directory run:

```bash
javac *.java
java BusReservationSystem
```

## Sample Usage

```
=====================================================
      WELCOME TO THE BUS RESERVATION SYSTEM
=====================================================
-----------------------------------------------------
1. Add Bus
2. View All Buses
3. Update Bus Capacity
4. Delete Bus
5. Book Ticket
6. View All Bookings
7. Cancel Booking
8. Exit
-----------------------------------------------------
Enter your choice: 1

--- Add New Bus ---
Enter Bus ID (e.g. B001): B001
Enter Bus Name: Super Line Express
Enter Route (e.g. Colombo - Kandy): Colombo - Kandy
Enter Total Seats: 40
Enter Ticket Price (Rs.): 500
Success: Bus 'B001' has been added.
```

## Notes

- All input is validated (non-empty strings, positive numbers, seat
  availability) with clear error messages shown to the user.
- Data is stored in memory for the duration of the program run (no external
  database is required for this mini project).
