import java.util.*;

class Room {
    int roomNumber;
    String roomType;
    double pricePerDay;
    boolean isAvailable;

    Room(int roomNumber, String roomType, double pricePerDay, boolean isAvailable) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.pricePerDay = pricePerDay;
        this.isAvailable = isAvailable;
    }

    void displayRoom() {
        System.out.println("Room Number: " + roomNumber + 
                           ", Type: " + roomType + 
                           ", Price: " + pricePerDay + 
                           ", Available: " + isAvailable);
    }
}

class Customer {
    int customerId;
    String name;
    String contactNumber;
    int allocatedRoom;

    Customer(int customerId, String name, String contactNumber, int allocatedRoom) {
        this.customerId = customerId;
        this.name = name;
        this.contactNumber = contactNumber;
        this.allocatedRoom = allocatedRoom;
    }

    void displayCustomer() {
        System.out.println("Customer ID: " + customerId + 
                           ", Name: " + name + 
                           ", Contact: " + contactNumber + 
                           ", Room Allocated: " + allocatedRoom);
    }
}

public class HotelManagementSystem {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static HashMap<Integer, Customer> roomCustomerMap = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    // Add Room
    static void addRoom() {
        System.out.print("Enter Room Number: ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Room Type: ");
        String type = sc.nextLine();
        System.out.print("Enter Price per Day: ");
        double price = sc.nextDouble();
        rooms.add(new Room(number, type, price, true));
        System.out.println("Room added successfully.");
    }

    // Display Available Rooms
    static void displayAvailableRooms() {
        System.out.println("--- Available Rooms ---");
        for (Room r : rooms) {
            if (r.isAvailable) r.displayRoom();
        }
    }

    // Add Customer
    static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Contact Number: ");
        String contact = sc.nextLine();
        customers.add(new Customer(id, name, contact, -1));
        System.out.println("Customer added successfully.");
    }

    // Book Room
    static void bookRoom() {
        System.out.print("Enter Customer ID: ");
        int id = sc.nextInt();
        System.out.print("Enter Room Number: ");
        int roomNo = sc.nextInt();

        Room room = null;
        for (Room r : rooms) {
            if (r.roomNumber == roomNo) {
                room = r;
                break;
            }
        }

        if (room != null && room.isAvailable) {
            for (Customer c : customers) {
                if (c.customerId == id) {
                    c.allocatedRoom = roomNo;
                    room.isAvailable = false;
                    roomCustomerMap.put(roomNo, c);
                    System.out.println("Room booked successfully.");
                    return;
                }
            }
            System.out.println("Customer not found.");
        } else {
            System.out.println("Room not available.");
        }
    }

    // Checkout Customer
    static void checkoutCustomer() {
        System.out.print("Enter Room Number to checkout: ");
        int roomNo = sc.nextInt();
        if (roomCustomerMap.containsKey(roomNo)) {
            Customer c = roomCustomerMap.get(roomNo);
            c.allocatedRoom = -1;
            for (Room r : rooms) {
                if (r.roomNumber == roomNo) {
                    r.isAvailable = true;
                    break;
                }
            }
            roomCustomerMap.remove(roomNo);
            System.out.println("Checkout successful.");
        } else {
            System.out.println("No customer found for this room.");
        }
    }

    // Display All Customers
    static void displayAllCustomers() {
        System.out.println("--- Customer Records ---");
        for (Customer c : customers) {
            c.displayCustomer();
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Hotel Management Menu ---");
            System.out.println("1. Add Room");
            System.out.println("2. Display Available Rooms");
            System.out.println("3. Add Customer");
            System.out.println("4. Book Room");
            System.out.println("5. Checkout Customer");
            System.out.println("6. Display All Customers");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: addRoom(); break;
                case 2: displayAvailableRooms(); break;
                case 3: addCustomer(); break;
                case 4: bookRoom(); break;
                case 5: checkoutCustomer(); break;
                case 6: displayAllCustomers(); break;
                case 7: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}
