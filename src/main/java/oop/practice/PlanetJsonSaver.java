package testing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.io.IOException;

public class PlanetJsonSaver {

    private String universe;

    public PlanetJsonSaver(String universe) {
        this.universe = universe;
    }

    public void saveToJson(testing.Individual individual) {
        ObjectMapper mapper = new ObjectMapper();
        File outputFile = new File("src/main/resources/output/" + this.universe + ".json");
        ArrayNode individualsArray;

        try {
            // Check if the file exists
            if (outputFile.exists()) {
                JsonNode existingData = mapper.readTree(outputFile);
                individualsArray = existingData.isArray() ? (ArrayNode) existingData : mapper.createArrayNode().add(existingData);
            } else {
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
