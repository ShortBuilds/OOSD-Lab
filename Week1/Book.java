class Book {
    private int bookId;
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Setters with validation
    public void setBookId(int bookId) { this.bookId = bookId; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setPrice(double price) {
        if (price > 0) this.price = price;
        else System.out.println("Invalid price. Must be positive.");
    }
    public void setAvailable(boolean available) { this.available = available; }

    // Getters
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public boolean isAvailable() { return available; }
}

public class BookDemo {
    public static void main(String[] args) {
        Book book = new Book();
        book.setBookId(101);
        book.setTitle("Effective Java");
        book.setAuthor("Joshua Bloch");
        book.setPrice(550.75);
        book.setAvailable(true);

        System.out.println("Book Details:");
        System.out.println("ID: " + book.getBookId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Price: " + book.getPrice());
        System.out.println("Available: " + book.isAvailable());
    }
}
