import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyByteStream {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Open source and destination files
            fis = new FileInputStream("source.txt");
            fos = new FileOutputStream("destination.txt");

            int data;
            // Read from source and write to destination
            while ((data = fis.read()) != -1) {
                fos.write(data);
            }

            System.out.println("File copied successfully using byte streams.");
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } finally {
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.out.println("Error closing files.");
            }
        }
    }
}
