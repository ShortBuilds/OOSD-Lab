class Room<T, U> {
    private T roomId;
    private U roomAttribute;

    public Room(T roomId, U roomAttribute) {
        this.roomId = roomId;
        this.roomAttribute = roomAttribute;
    }

    public void displayDetails() {
        System.out.println("Room ID: " + roomId);
        System.out.println("Room Attribute: " + roomAttribute);
    }
}

public class GenericRoomDemo {
    public static void main(String[] args) {
        Room<Integer, String> r1 = new Room<>(101, "Deluxe Room");
        Room<String, Double> r2 = new Room<>("Room-202", 4500.75);

        r1.displayDetails();
        r2.displayDetails();
    }
}
