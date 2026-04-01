import java.io.*;
import java.util.ArrayList;
import java.util.List;

// Serializable Room class
class Room implements Serializable {
    int roomNumber;
    String roomType;
    double pricePerNight;
    boolean bookingStatus;
    String guestName;

    Room(int roomNumber, String roomType, double pricePerNight, boolean bookingStatus, String guestName) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerNight = pricePerNight;
        this.bookingStatus = bookingStatus;
        this.guestName = guestName;
    }

    void displayDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: " + pricePerNight);
        System.out.println("Booking Status: " + (bookingStatus ? "Booked" : "Available"));
        System.out.println("Guest Name: " + guestName);
    }
}

public class SerializationHotelDemo {
    private static final String FILE_NAME = "hotelRooms.dat";

    // Serialize room list
    static void serializeRooms(List<Room> rooms) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(rooms);
            System.out.println("Rooms serialized successfully.");
        } catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }
    }

    // Deserialize room list
    static List<Room> deserializeRooms() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Room>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        // Create room objects
        List<Room> rooms = new ArrayList<>();
        rooms.add(new Room(201, "Standard", 2000, false, ""));
        rooms.add(new Room(202, "Deluxe", 3500, true, "Ravi"));

        // Serialize rooms
        serializeRooms(rooms);

        // Deserialize and display
        List<Room> deserializedRooms = deserializeRooms();
        System.out.println("--- Room Details ---");
        for (Room r : deserializedRooms) {
            r.displayDetails();
            System.out.println();
        }

        // Update booking status
        if (!deserializedRooms.isEmpty()) {
            Room roomToUpdate = deserializedRooms.get(0);
            roomToUpdate.bookingStatus = true;
            roomToUpdate.guestName = "Ananya";
            System.out.println("--- After Update ---");
            roomToUpdate.displayDetails();

            // Re-serialize updated list
            serializeRooms(deserializedRooms);
        }
    }
}
