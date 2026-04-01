// Thread class for Room Cleaning
class RoomCleaning extends Thread {
    private String roomName;

    RoomCleaning(String roomName) {
        this.roomName = roomName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(roomName + " - Cleaning step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Cleaning interrupted");
            }
        }
        System.out.println(roomName + " cleaning completed.");
    }
}

// Runnable class for Food Delivery
class FoodDelivery implements Runnable {
    private String orderName;

    FoodDelivery(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(orderName + " - Delivery step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Delivery interrupted");
            }
        }
        System.out.println(orderName + " delivery completed.");
    }
}

// Thread class for Maintenance
class Maintenance extends Thread {
    private String taskName;

    Maintenance(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(taskName + " - Maintenance step " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Maintenance interrupted");
            }
        }
        System.out.println(taskName + " maintenance completed.");
    }
}

public class HotelServiceDemo {
    public static void main(String[] args) {
        RoomCleaning cleaning = new RoomCleaning("Room 101");
        FoodDelivery deliveryTask = new FoodDelivery("Order #A12");
        Thread delivery = new Thread(deliveryTask);
        Maintenance maintenance = new Maintenance("AC Repair");

        // Start all threads concurrently
        cleaning.start();
        delivery.start();
        maintenance.start();
    }
}
