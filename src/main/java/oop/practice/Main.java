package testing;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;


public class Main {

    public static int num;

    public static void main(String[] args) throws IOException {
        //read the input
        JsonNode data = getJsonNode("src/main/resources/input.json");

        //read the rules
        JsonNode classifierData = getJsonNode("src/main/resources/rules.json");

        //nested loop for good verification
        for (JsonNode entry : data) {
            testing.Individual individual = new testing.Individual(entry);
            boolean check = true;//for no repetition
            for (JsonNode classifierPlanet : classifierData) {//first of all we should check the planet
                testing.CheckPlanet classifier1 = new testing.CheckPlanet(classifierPlanet);
                if (classifier1.matchPlanet(individual)) {
                    classifier1.saveToJson(individual);
                    num++;
                    check = false;
                    break;
                }
            }
            if (check) {
                for (JsonNode classifier : classifierData) {//another loop for other classification because it should work independently
                    testing.OwnClassifier classifier1 = new testing.OwnClassifier(classifier);
                    if (classifier1.matches(individual)) {
                        classifier1.saveToJson(individual);
                        num++;
                        check = false;
                        break;
                    }
                }
            }
        }
        System.out.println(num);
    }

    private static JsonNode getJsonNode(String pathname) throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        File inputFile = new File(pathname);
        JsonNode data = mapper.readTree(inputFile).get("data");
        return data;
    }
}
