class RoomCharges<T extends Number> {
    private T price;
    private T discount;

    public RoomCharges(T price, T discount) {
        this.price = price;
        this.discount = discount;
    }

    public double totalPrice() {
        return price.doubleValue();
    }

    public double discountedPrice() {
        return price.doubleValue() - discount.doubleValue();
    }
}

public class RoomChargesDemo {
    public static void main(String[] args) {
        RoomCharges<Double> r1 = new RoomCharges<>(5000.0, 500.0);
        System.out.println("Total Price: " + r1.totalPrice());
        System.out.println("Discounted Price: " + r1.discountedPrice());

        RoomCharges<Integer> r2 = new RoomCharges<>(3000, 300);
        System.out.println("Total Price: " + r2.totalPrice());
        System.out.println("Discounted Price: " + r2.discountedPrice());
    }
}
