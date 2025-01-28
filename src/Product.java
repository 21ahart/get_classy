public class Product {
    private static int nextId = 1;
    private String id;
    private String name;
    private String description;
    private double cost;

    /**
     * Constructs a new Product with the specified details.
     *
     * @param id the unique identifier for the product
     * @param name the name of the product
     * @param description the description of the product
     * @param cost the cost of the product
     */
    public Product(String name, String description, double cost) {
        this.id = nextId++ + "";
        this.name = name;
        this.description = description;
        this.cost = cost;
    }

    /**
     * Gets the ID of the product.
     *
     * @return the ID of the product
     */
    public String getId() {
        return id;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name of the product
     */
    public String name() {
        return name;
    }

    /**
     * Gets the description of the product.
     *
     * @return the description of the product
     */
    public String description() {
        return description;
    }

    /**
     * Gets the cost of the product.
     *
     * @return the cost of the product
     */
    public double cost() {
        return cost;
    }

    /**
     * Converts the product details to a CSV format string.
     *
     * @return a CSV format string representing the product
     */
    public String toCSV() {
        return id + "," + name + "," + description + "," + cost;
    }

    /**
     * Converts the product details to a JSON format string.
     *
     * @return a JSON format string representing the product
     */
    public String toJSON() {
        return "{ \"id\": \"" + id + "\", \"name\": \"" + name + "\", \"description\": \"" + description + "\", \"cost\": " + cost + " }";
    }

    /**
     * Converts the product details to an XML format string.
     *
     * @return an XML format string representing the product
     */
    public String toXML() {
        return "<Product><id>" + id + "</id><name>" + name + "</name><description>" + description + "</description><cost>" + cost + "</cost></Product>";
    }
}