import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

public class PersonReader {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        boolean fileIsValid = false;

        while (!fileIsValid) {
            String fileName = chooseFile();
            if (fileName != null) {
                people = readFromFile(fileName);
                if (people.size() > 0) {
                    fileIsValid = true;
                } else {
                    System.out.println("No data read from file. Try again.");
                }
            } else {
                System.out.println("File selection cancelled. Exiting.");
                return;
            }
        }

        displayPeople(people);
    }

    private static String chooseFile() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile().getAbsolutePath();
        }
        return null;
    }

    private static ArrayList<Person> readFromFile(String fileName) {
        ArrayList<Person> people = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String firstName = parts[1];
                    String lastName = parts[2];
                    String title = parts[3];
                    int yearOfBirth = Integer.parseInt(parts[4]);
                    people.add(new Person(firstName, lastName, title, yearOfBirth));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
        return people;
    }

    private static void displayPeople(ArrayList<Person> people) {
        System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID#", "Firstname", "Lastname", "Title", "YOB");
        System.out.println("==============================================================");
        for (Person person : people) {
            System.out.printf("%-10s %-15s %-15s %-10s %-5d%n", person.getId(), person.getFirstName(), person.getLastName(), person.getTitle(), person.getYearOfBirth());
        }
    }
}