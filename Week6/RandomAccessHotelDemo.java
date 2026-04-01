import java.io.IOException;
import java.io.RandomAccessFile;

class HotelRoom {
    private static final int STRING_LENGTH = 20; // fixed length for room type
    private int roomNumber;
    private String roomType;
    private double pricePerNight;
    private boolean bookingStatus;

    HotelRoom(int roomNumber, String roomType, double pricePerNight, boolean bookingStatus) {
        this.roomNumber = roomNumber;
        this.roomType = padString(roomType, STRING_LENGTH);
        this.pricePerNight = pricePerNight;
        this.bookingStatus = bookingStatus;
    }

    // Pad or trim string to fixed length
    private String padString(String str, int length) {
        if (str.length() > length) return str.substring(0, length);
        StringBuilder sb = new StringBuilder(str);
        while (sb.length() < length) sb.append(" ");
        return sb.toString();
    }

    // Write room record to file
    void writeToFile(RandomAccessFile raf) throws IOException {
        raf.writeInt(roomNumber);
        raf.writeUTF(roomType);
        raf.writeDouble(pricePerNight);
        raf.writeBoolean(bookingStatus);
    }

    // Read room record from file
    static HotelRoom readFromFile(RandomAccessFile raf) throws IOException {
        int roomNumber = raf.readInt();
        String roomType = raf.readUTF().trim();
        double pricePerNight = raf.readDouble();
        boolean bookingStatus = raf.readBoolean();
        return new HotelRoom(roomNumber, roomType, pricePerNight, bookingStatus);
    }

    void displayDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Price per Night: " + pricePerNight);
        System.out.println("Booking Status: " + (bookingStatus ? "Booked" : "Available"));
    }
}

public class RandomAccessHotelDemo {
    public static void main(String[] args) {
        try (RandomAccessFile raf = new RandomAccessFile("rooms.dat", "rw")) {
            // Add room records
            HotelRoom r1 = new HotelRoom(101, "Deluxe", 3500, false);
            HotelRoom r2 = new HotelRoom(102, "Suite", 5000, true);

            r1.writeToFile(raf);
            r2.writeToFile(raf);

            // Seek to first record and display
            raf.seek(0);
            HotelRoom room = HotelRoom.readFromFile(raf);
            System.out.println("--- Room Details ---");
            room.displayDetails();

            // Seek to second record and update booking status
            raf.seek(raf.getFilePointer()); // already at next record
            HotelRoom room2 = HotelRoom.readFromFile(raf);
            System.out.println("--- Before Update ---");
            room2.displayDetails();

            // Update booking status
            raf.seek(4 + 2 + 20 + 8); // approximate seek to booking status of first record
            raf.writeBoolean(true);

            System.out.println("--- Booking Status Updated ---");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        }
    }
}
