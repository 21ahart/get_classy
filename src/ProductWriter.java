import java.util.*;
import java.io.*;

public class ProductWriter {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean moreData = true;

        while (moreData) {
            String name = SafeInput.getNonZeroLenString(in, "Enter Name");
            String description = SafeInput.getNonZeroLenString(in, "Enter Description");
            double price = SafeInput.getRangedDouble(in, "Enter Price", 0, 1000000);

            products.add(new Product(name, description, price));

            moreData = SafeInput.getYNConfirm(in, "Do you want to enter another product?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save the data");
        saveToFile(products, fileName);
    }

    private static void saveToFile(ArrayList<Product> products, String fileName) {
        String relativePath = "C:\\Users\\aiden\\code\\get_classy\\src\\data\\" + fileName;
        try (PrintWriter writer = new PrintWriter(new File(relativePath))) {
            for (Product product : products) {
                writer.println(product.toCSV());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}