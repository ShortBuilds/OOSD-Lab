class RoomDataDisplay {
    // Generic method
    public static <T> void display(T data) {
        System.out.println("Data: " + data);
    }

    public static void main(String[] args) {
        display(101);           // Room number (Integer)
        display("Suite Room");  // Room type (String)
        display(3500.50);       // Price per night (Double)
        display(true);          // Booking status (Boolean)
    }
}
