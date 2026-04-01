public class HotelBillingSystem {
    public static void main(String[] args) {
        // Initialize primitive values
        int tariff = 3000;   // per day
        int days = 4;
        double serviceCharges = 1500.50;

        // Autoboxing: converting primitives to wrapper objects
        Integer roomTariff = tariff;
        Integer numberOfDays = days;
        Double extraCharges = serviceCharges;

        // Unboxing: converting wrapper objects back to primitives for calculation
        int totalRoomCost = roomTariff * numberOfDays;
        double finalBill = totalRoomCost + extraCharges;

        // Display bill details
        System.out.println("---- Hotel Billing System ----");
        System.out.println("Room Tariff (per day): " + roomTariff);
        System.out.println("Number of Days Stayed: " + numberOfDays);
        System.out.println("Service Charges: " + extraCharges);
        System.out.println("Total Room Cost: " + totalRoomCost);
        System.out.println("Final Bill Amount: " + finalBill);
    }
}
