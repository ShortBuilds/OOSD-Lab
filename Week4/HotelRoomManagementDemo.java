// Shared resource: Hotel with limited rooms
class Hotel {
    private int availableRooms;

    Hotel(int totalRooms) {
        this.availableRooms = totalRooms;
    }

    // Synchronized method for booking a room
    synchronized void bookRoom(String customerName) {
        while (availableRooms == 0) {
            System.out.println(customerName + " is waiting for a room...");
            try {
                wait(); // Wait until a room is released
            } catch (InterruptedException e) {
                System.out.println(customerName + " interrupted while waiting.");
            }
        }
        availableRooms--;
        System.out.println(customerName + " booked a room. Rooms left: " + availableRooms);
    }

    // Synchronized method for releasing a room
    synchronized void releaseRoom(String customerName) {
        availableRooms++;
        System.out.println(customerName + " released a room. Rooms left: " + availableRooms);
        notify(); // Notify waiting threads
    }
}

// Customer thread for booking
class Customer extends Thread {
    private Hotel hotel;
    private String customerName;

    Customer(Hotel hotel, String customerName) {
        this.hotel = hotel;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        hotel.bookRoom(customerName);
    }
}

// Customer thread for releasing
class RoomReleaser extends Thread {
    private Hotel hotel;
    private String customerName;

    RoomReleaser(Hotel hotel, String customerName) {
        this.hotel = hotel;
        this.customerName = customerName;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(2000); // Simulate delay before releasing
        } catch (InterruptedException e) {
            System.out.println("Release interrupted");
        }
        hotel.releaseRoom(customerName);
    }
}

// Main class
public class HotelRoomManagementDemo {
    public static void main(String[] args) {
        Hotel hotel = new Hotel(1); // Only 1 room available

        Customer c1 = new Customer(hotel, "Customer-1");
        Customer c2 = new Customer(hotel, "Customer-2");
        RoomReleaser releaser = new RoomReleaser(hotel, "Customer-1");

        c1.start();
        c2.start();
        releaser.start();
    }
}
