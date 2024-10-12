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
            testing.Individual individual = new testing.Individual(entry);
            boolean check = true;
            for (JsonNode classifierPlanet : classifierData) {
                CheckPlanet classifier1 = new CheckPlanet(classifierPlanet);
                if (classifier1.matches1(individual)) {
                    classifier1.saveToJson(individual);
                    check = false;
                    break;
                }
            }if(check){
                for (JsonNode classifier : classifierData) {
                    testing.OwnClassifier classifier1 = new testing.OwnClassifier(classifier);
                    if (classifier1.matches(individual)) {
                        classifier1.saveToJson(individual);
                        check = false;
                        break;
                    }}
            }
        }
    }}
