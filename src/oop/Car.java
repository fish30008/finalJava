package oop;
public class Car {
    private int id;
    private String type;
    private String passengers;
    private boolean isDining;
    private int consumption;

    public Car(int id, String type, String passengers, boolean isDining, int consumption) {
        this.id = id;
        this.type = type;
        this.passengers = passengers;
        this.isDining = isDining;
        this.consumption = consumption;
    }

    // Factory method to parse a Car object from a JSON string
    public static Car fromJSONString(String json) {
        json = json.trim(); // Remove extra whitespace

        // Extract values manually
        int id = Integer.parseInt(extractValue(json, "id"));
        String type = extractValue(json, "type").replace("\"", ""); // Remove quotes
        String passengers = extractValue(json, "passengers").replace("\"", "");
        boolean isDining = Boolean.parseBoolean(extractValue(json, "isDining"));
        int consumption = Integer.parseInt(extractValue(json, "consumption"));

        return new Car(id, type, passengers, isDining, consumption);
    }

    // Helper method to extract a value by key
    private static String extractValue(String json, String key) {
        String[] parts = json.split("\"" + key + "\":");
        String valuePart = parts[1].split(",")[0].replace("}", ""); // Handle last field
        return valuePart.trim();
    }

    @Override
    public String toString() {
        return String.format("Car{id=%d, type=%s, passengers=%s, isDining=%b, consumption=%d}",
                id, type, passengers, isDining, consumption);
    }
}
