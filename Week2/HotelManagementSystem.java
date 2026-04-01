// Enum definition with constructor and methods
enum RoomType {
    STANDARD(2000),
    DELUXE(3500),
    SUITE(5000);

    private int baseTariff;

    // Enum constructor
    RoomType(int baseTariff) {
        this.baseTariff = baseTariff;
    }

    // Getter method
    public int getBaseTariff() {
        return baseTariff;
    }

    // Method to calculate total cost
    public int calculateCost(int days) {
        return baseTariff * days;
    }
}

public class HotelManagementSystem {
    public static void main(String[] args) {
        RoomType selectedRoom = RoomType.SUITE;
        int daysStayed = 5;

        System.out.println("---- Hotel Management System ----");
        System.out.println("Selected Room Type: " + selectedRoom);
        System.out.println("Base Tariff per Day: " + selectedRoom.getBaseTariff());
        System.out.println("Number of Days Stayed: " + daysStayed);
        System.out.println("Total Room Tariff: " + selectedRoom.calculateCost(daysStayed));
    }
}
