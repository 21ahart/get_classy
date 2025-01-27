import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class ProductReader {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        boolean fileIsValid = false;

        while (!fileIsValid) {
            String fileName = chooseFile();
            if (fileName != null) {
                products = readFromFile(fileName);
                if (products.size() > 0) {
                    fileIsValid = true;
                } else {
                    System.out.println("No data read from file. Try again.");
                }
            } else {
                System.out.println("File selection cancelled. Exiting.");
                return;
            }
        }

        displayProducts(products);
    }

    private static String chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    private static ArrayList<Product> readFromFile(String fileName) {
        ArrayList<Product> products = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(", ");
                if (parts.length == 4) {
                    String id = parts[0];
                    String name = parts[1];
                    String description = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    products.add(new Product(id, name, description, price));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return products;
    }

    private static void displayProducts(ArrayList<Product> products) {
        System.out.printf("%-10s %-15s %-25s %-10s%n", "ID#", "Name", "Description", "Price");
        System.out.println("===========================================================================");
        for (Product product : products) {
            System.out.printf("%-10s %-15s %-25s %-10.2f%n", product.getId(), product.getName(), product.getDescription(), product.getPrice());
        }
    }
}