abstract class AbstractRoom {
    protected int roomNumber;
    protected double basePrice;

    AbstractRoom(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
    }

    abstract double calculateTariff();

    void displayRoomDetails() {
        System.out.println("Room Number: " + roomNumber);
        System.out.println("Base Price: " + basePrice);
    }
}

interface Amenities {
    void provideWifi();
    void provideBreakfast();
}

class StandardRoomAbs extends AbstractRoom implements Amenities {
    private boolean ac;

    StandardRoomAbs(int roomNumber, double basePrice, boolean ac) {
        super(roomNumber, basePrice);
        this.ac = ac;
    }

    @Override
    double calculateTariff() {
        return ac ? basePrice + 500 : basePrice;
    }

    @Override
    public void provideWifi() {
        System.out.println("WiFi not available in Standard Room.");
    }

    @Override
    public void provideBreakfast() {
        System.out.println("Breakfast available at extra cost.");
    }
}

class LuxuryRoomAbs extends AbstractRoom implements Amenities {
    private boolean premiumService;

    LuxuryRoomAbs(int roomNumber, double basePrice, boolean premiumService) {
        super(roomNumber, basePrice);
        this.premiumService = premiumService;
    }

    @Override
    double calculateTariff() {
        return premiumService ? basePrice + 2000 : basePrice;
    }

    @Override
    public void provideWifi() {
        System.out.println("WiFi available in Luxury Room.");
    }

    @Override
    public void provideBreakfast() {
        System.out.println("Complimentary Breakfast included.");
    }
}

public class AbstractDemo {
    public static void main(String[] args) {
        AbstractRoom sr = new StandardRoomAbs(501, 2500, true);
        AbstractRoom lr = new LuxuryRoomAbs(601, 6000, true);

        System.out.println("--- Standard Room ---");
        sr.displayRoomDetails();
        System.out.println("Tariff: " + sr.calculateTariff());
        ((Amenities) sr).provideWifi();
        ((Amenities) sr).provideBreakfast();

        System.out.println("--- Luxury Room ---");
        lr.displayRoomDetails();
        System.out.println("Tariff: " + lr.calculateTariff());
        ((Amenities) lr).provideWifi();
        ((Amenities) lr).provideBreakfast();
    }
}
