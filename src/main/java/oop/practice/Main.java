package testing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        //read the input
        File inputFile = new File("src/main/resources/test-input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        //read the rules
        File classifierFile = new File("src/main/resources/rules.json");
        JsonNode classifierData = mapper.readTree(classifierFile).get("data");

        //nested loop for good verification
        for (JsonNode entry : data) {
            Individual individual = new Individual(entry);
            for (JsonNode classifierEntry : classifierData) {
                testing.OwnClassifier classifier = new testing.OwnClassifier(classifierEntry);
                if (classifier.matches(individual)) {
                    //save if it's matched
                    classifier.saveToJson(individual);
                    break; //exit after match
                }
            }
        }
    }
}
