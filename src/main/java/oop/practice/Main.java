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
        File inputFile = new File("src/main/resources/input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        //read the rules
        File classifierFile = new File("src/main/resources/rules.json");
        JsonNode classifierData = mapper.readTree(classifierFile).get("data");

        //nested loop for good verification
        for (JsonNode entry : data) {
            testing.Individual individual = new testing.Individual(entry);
            boolean check = true;//for no repetition
            for (JsonNode classifierPlanet : classifierData) {//first of all we should check the planet
                testing.CheckPlanet classifier1 = new testing.CheckPlanet(classifierPlanet);
                if (classifier1.matches1(individual)) {
                    classifier1.saveToJson(individual);
                    check = false;
                    break;
                }
            }if(check){
                for (JsonNode classifier : classifierData) {//another loop for other classification because it should work independently
                    testing.OwnClassifier classifier1 = new testing.OwnClassifier(classifier);
                    if (classifier1.matches(individual)) {
                        classifier1.saveToJson(individual);
                        check = false;
                        break;
                    }}
            }
        }
    }}
