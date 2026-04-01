class Room {
    protected int roomNumber;
    protected String roomType;
    protected double basePrice;

    // Constructor overloading
    Room(int roomNumber, String roomType) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }

    Room(int roomNumber, String roomType, double basePrice) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.basePrice = basePrice;
    }

    void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Room Type: " + roomType);
        System.out.println("Base Price: " + basePrice);
    }
}

class DeluxeRoom extends Room {
    private boolean wifi;
    private boolean breakfast;

    DeluxeRoom(int roomNumber, String roomType) {
        super(roomNumber, roomType);
    }

    DeluxeRoom(int roomNumber, String roomType, double basePrice, boolean wifi, boolean breakfast) {
        super(roomNumber, roomType, basePrice);
        this.wifi = wifi;
        this.breakfast = breakfast;
    }

    void displayDeluxeDetails() {
        super.displayRoomDetails();
        System.out.println("Free WiFi: " + wifi);
        System.out.println("Complimentary Breakfast: " + breakfast);
    }
}

public class RoomDemo {
    public static void main(String[] args) {
        Room r1 = new Room(101, "Standard");
        Room r2 = new Room(102, "Suite", 3000);

        DeluxeRoom dr1 = new DeluxeRoom(201, "Deluxe");
        DeluxeRoom dr2 = new DeluxeRoom(202, "Deluxe Suite", 5000, true, true);

        System.out.println("--- Room 1 ---");
        r1.displayRoomDetails();
        System.out.println("--- Room 2 ---");
        r2.displayRoomDetails();
        System.out.println("--- Deluxe Room 1 ---");
        dr1.displayDeluxeDetails();
        System.out.println("--- Deluxe Room 2 ---");
        dr2.displayDeluxeDetails();
    }
}
