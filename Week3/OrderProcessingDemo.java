// Thread class for Order Validation
class OrderValidation extends Thread {
    private String orderId;

    OrderValidation(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println(orderId + " - Validating order...");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Validation interrupted");
        }
        System.out.println(orderId + " - Validation completed.");
    }
}

// Runnable class for Payment Processing
class PaymentProcessing implements Runnable {
    private String orderId;

    PaymentProcessing(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println(orderId + " - Processing payment...");
        try {
            Thread.sleep(1200);
        } catch (InterruptedException e) {
            System.out.println("Payment interrupted");
        }
        System.out.println(orderId + " - Payment completed.");
    }
}

// Thread class for Order Shipment
class OrderShipment extends Thread {
    private String orderId;

    OrderShipment(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println(orderId + " - Preparing shipment...");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Shipment interrupted");
        }
        System.out.println(orderId + " - Shipment dispatched.");
    }
}

public class OrderProcessingDemo {
    public static void main(String[] args) {
        OrderValidation validation = new OrderValidation("Order #B45");
        PaymentProcessing paymentTask = new PaymentProcessing("Order #B45");
        Thread payment = new Thread(paymentTask);
        OrderShipment shipment = new OrderShipment("Order #B45");

        // Start all threads simultaneously
        validation.start();
        payment.start();
        shipment.start();
    }
}
