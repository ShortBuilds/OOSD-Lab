class RoomArrayDemo {
    // Generic method to print arrays
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Integer[] roomNumbers = {101, 102, 103};
        String[] roomTypes = {"Standard", "Deluxe", "Suite"};
        Double[] roomPrices = {2000.0, 3500.0, 5000.0};

        System.out.println("Room Numbers:");
        printArray(roomNumbers);

        System.out.println("Room Types:");
        printArray(roomTypes);

        System.out.println("Room Prices:");
        printArray(roomPrices);
    }
}
