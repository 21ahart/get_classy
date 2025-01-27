import java.util.Calendar;

/**
 * Represents a person with an ID, first name, last name, title, and year of
 * birth.
 */
public class Person {
    private String id;
    private String firstName;
    private String lastName;
    private String title;
    private int YOB;

    /**
     * Constructs a new Person with the specified details.
     *
     * @param id          the unique identifier for the person
     * @param firstName   the first name of the person
     * @param lastName    the last name of the person
     * @param title       the title of the person (e.g., Mr., Ms., Dr.)
     * @param yearOfBirth the year of birth of the person
     */
    public Person(String id, String firstName, String lastName, String title, int yearOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = yearOfBirth;
    }

    /**
     * Returns the full name of the person.
     *
     * @return the full name of the person
     */
    public String fullName() {
        return firstName + " " + lastName;
    }

    /**
     * Returns the formal name of the person, including their title.
     *
     * @return the formal name of the person
     */
    public String formalName() {
        return title + " " + fullName();
    }

    /**
     * Returns the current age of the person.
     *
     * @return the current age of the person
     */
    public String getAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        return String.valueOf(currentYear - YOB);
    }

    /**
     * Returns the age of the person in the specified year.
     *
     * @param year the year to calculate the age for
     * @return the age of the person in the specified year
     */
    public String getAge(int year) {
        return String.valueOf(year - YOB);
    }

    /**
     * Returns a CSV representation of the person.
     *
     * @return a CSV representation of the person
     */
    public String toCSV() {
        return id + "," + firstName + "," + lastName + "," + title + "," + YOB;
    }

    /**
     * Returns a JSON representation of the person.
     *
     * @return a JSON representation of the person
     */
    public String toJSON() {
        return "{ \"id\": \"" + id + "\", \"firstName\": \"" + firstName + "\", \"lastName\": \"" + lastName
                + "\", \"title\": \"" + title + "\", \"YOB\": " + YOB + " }";
    }

    /**
     * Returns an XML representation of the person.
     *
     * @return an XML representation of the person
     */
    public String toXML() {
        return "<Person>" + "<id>" + id + "</id>" + "<firstName>" + firstName + "</firstName>" + "<lastName>" + lastName
                + "</lastName>" + "<title>" + title + "</title>" + "<YOB>" + YOB + "</YOB>" + "</Person>";
    }
}