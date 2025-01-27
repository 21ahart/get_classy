
import org.junit.*;
import static org.junit.Assert.*;

/**
 * Unit tests for the Person class.
 */
public class PersonTest {

    @Test
    public void testFullName() {
        Person person = new Person("001", "John", "Doe", "Mr.", 1990);
        assertEquals("John Doe", person.fullName());
    }

    @Test
    public void testFormalName() {
        Person person = new Person("002", "Jane", "Smith", "Dr.", 1985);
        assertEquals("Dr. Jane Smith", person.formalName());
    }

    @Test
    public void testGetAgeCurrentYear() {
        Person person = new Person("003", "Alice", "Johnson", "Ms.", 2000);
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        assertEquals(String.valueOf(currentYear - 2000), person.getAge());
    }

    @Test
    public void testGetAgeSpecificYear() {
        Person person = new Person("004", "Bob", "Brown", "Mr.", 1995);
        assertEquals("25", person.getAge(2020));
    }

    @Test
    public void testToCSV() {
        Person person = new Person("005", "Charlie", "Davis", "Mr.", 1980);
        assertEquals("005,Charlie,Davis,Mr.,1980", person.toCSV());
    }

    @Test
    public void testToJSON() {
        Person person = new Person("006", "Diana", "Evans", "Ms.", 1975);
        String expectedJSON = "{ \"id\": \"006\", \"firstName\": \"Diana\", \"lastName\": \"Evans\", \"title\": \"Ms.\", \"YOB\": 1975 }";
        assertEquals(expectedJSON, person.toJSON());
    }

    @Test
    public void testToXML() {
        Person person = new Person("007", "Eve", "Franklin", "Dr.", 1965);
        String expectedXML = "<Person><id>007</id><firstName>Eve</firstName><lastName>Franklin</lastName><title>Dr.</title><YOB>1965</YOB></Person>";
        assertEquals(expectedXML, person.toXML());
    }
}
