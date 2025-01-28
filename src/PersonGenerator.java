
import java.util.*;
import java.io.*;


public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean moreData = true;

        while (moreData) {
            String firstName = SafeInput.getNonZeroLenString(in, "Enter First Name");
            String lastName = SafeInput.getNonZeroLenString(in, "Enter Last Name");
            String title = SafeInput.getNonZeroLenString(in, "Enter Title");
            int yearOfBirth = SafeInput.getRangedInt(in, "Enter Year of Birth", 0, 2025);

            people.add(new Person(firstName, lastName, title, yearOfBirth));

            moreData = SafeInput.getYNConfirm(in, "Do you want to enter another person?");
        }

        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save the data");
        saveToFile(people, fileName);
    }

    private static void saveToFile(ArrayList<Person> people, String fileName) {
        String relativePath = "C:\\Users\\aiden\\code\\get_classy\\src\\data\\" + fileName;
        try (PrintWriter writer = new PrintWriter(new File(relativePath))) {
            for (Person person : people) {
                writer.println(person.toCSV());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }
}