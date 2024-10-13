package testing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OwnClassifier {

    //use wrapper because this can handle null values
    private String universe;
    private Boolean isHumanoid;
    private Integer age;
    private List<String> traits;

    public OwnClassifier(JsonNode entry) {//save classifier class for every entry
        this.universe = entry.get("universe").asText();
        this.isHumanoid = entry.get("isHumanoid").asBoolean();
        this.age = entry.get("age").asInt();
        this.traits = new ArrayList<>();
        for (JsonNode trait : entry.get("traits")) {
            this.traits.add(trait.asText());
        }
    }

    public boolean matches(testing.Individual individual) {
        // Match based on planet because it's main parameter of the object with wich is the best way to classify

        if (individual.getTraits() != null && !individual.getTraits().isEmpty()) {
            for (String individualTrait : individual.getTraits()) {
                if (this.traits.contains(individualTrait)) {
                    return true;

                }
            }
        }
        if(individual.isHumanoid() != null &&individual.isHumanoid() == this.isHumanoid) {
            if(individual.getAge() != null && individual.getAge() <= this.age) return true;}
        return false;
    }

    //i did this method with gpt because i'm freshman in java
    public void saveToJson(testing.Individual individual) {
        ObjectMapper mapper = new ObjectMapper();
        File outputFile = new File("src/main/resources/output/" + this.universe + ".json");

        ArrayNode individualsArray;

        try {
            // Check if the file exists
            if (outputFile.exists()) {
                // Read the existing data
                JsonNode existingData = mapper.readTree(outputFile);
                if (existingData.isArray()) {
                    individualsArray = (ArrayNode) existingData;
                } else {
                    // If file exists but is not an array, create a new array and add existing data
                    individualsArray = mapper.createArrayNode();
                    individualsArray.add(existingData);
                }
            } else {
                // If file does not exist, create a new array
                individualsArray = mapper.createArrayNode();
            }

            // Add the new individual to the array
            JsonNode individualNode = mapper.valueToTree(individual);
            individualsArray.add(individualNode);

            // Write the updated array back to the file
            mapper.writeValue(outputFile, individualsArray);
            System.out.println("Appended individual to: " + outputFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
