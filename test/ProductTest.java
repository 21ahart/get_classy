import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    @Test
    public void testId() {
        Product product = new Product("Widget", "A small widget", 10.0);
        assertEquals("1", product.getId());
    }

    @Test
    public void testName() {
        Product product = new Product("Widget", "A small widget", 10.0);
        assertEquals("Widget", product.name());
    }

    @Test 
    public void testDescription() {
        Product product = new Product("Gadget", "A large gadget", 20.0);
        assertEquals("A large gadget", product.description());
    }

    @Test
    public void testCost() {
        Product product = new Product("Thing", "A medium thing", 15.0);
        assertEquals(15.0, product.cost(), 0.0);
    }

    @Test
    public void testToCSV() {
        Product product = new Product("Item", "A generic item", 5.0);
        assertEquals("004,Item,A generic item,5.0", product.toCSV());
    }

    @Test
    public void testToJSON() {
        Product product = new Product("Object", "A specific object", 25.0);
        String expectedJSON = "{ \"id\": \"1\", \"name\": \"Object\", \"description\": \"A specific object\", \"cost\": 25.0 }";
        assertEquals(expectedJSON, product.toJSON());
    }

    @Test
    public void testToXML() {
        Product product = new Product("Artifact", "An ancient artifact", 100.0);
        String expectedXML = "<Product><id>1</id><name>Artifact</name><description>An ancient artifact</description><cost>100.0</cost></Product>";
        assertEquals(expectedXML, product.toXML());
    }

}
