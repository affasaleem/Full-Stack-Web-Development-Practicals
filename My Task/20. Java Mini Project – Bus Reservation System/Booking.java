/*
 * Booking.java
 * Represents a single passenger booking, linking a passenger to a bus.
 */
public class Booking {

    private String passengerId;
    private String passengerName;
    private String busNumber;
    private String source;
    private String destination;

    public Booking(String passengerId, String passengerName, String busNumber,
                    String source, String destination) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.busNumber = busNumber;
        this.source = source;
        this.destination = destination;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public String getPassengerName() {
        return passengerName;
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

    @Override
    public String toString() {
        return String.format("Passenger ID: %-6s | Name: %-15s | Bus No: %-8s | %-12s -> %-12s",
                passengerId, passengerName, busNumber, source, destination);
    }
}
