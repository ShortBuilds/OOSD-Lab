class RoomBooking {
    protected int roomNumber;
    protected double baseTariff;

    RoomBooking(int roomNumber, double baseTariff) {
        this.roomNumber = roomNumber;
        this.baseTariff = baseTariff;
    }

    double calculateTariff() {
        return baseTariff;
    }
}

class StandardRoom extends RoomBooking {
    private boolean ac;

    StandardRoom(int roomNumber, double baseTariff, boolean ac) {
        super(roomNumber, baseTariff);
        this.ac = ac;
    }

    @Override
    double calculateTariff() {
        return ac ? baseTariff + 500 : baseTariff;
    }
}

class LuxuryRoom extends RoomBooking {
    private boolean premiumService;

    LuxuryRoom(int roomNumber, double baseTariff, boolean premiumService) {
        super(roomNumber, baseTariff);
        this.premiumService = premiumService;
    }

    @Override
    double calculateTariff() {
        return premiumService ? baseTariff + 2000 : baseTariff;
    }
}

public class BookingDemo {
    public static void main(String[] args) {
        RoomBooking rb1 = new StandardRoom(301, 2000, true);
        RoomBooking rb2 = new LuxuryRoom(401, 5000, true);

        System.out.println("Standard Room Tariff: " + rb1.calculateTariff());
        System.out.println("Luxury Room Tariff: " + rb2.calculateTariff());
    }
}
