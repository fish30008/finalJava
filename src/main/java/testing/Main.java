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
        File inputFile = new File("src/main/resources/test-input.json");
        JsonNode data = mapper.readTree(inputFile).get("data");

        testing.Universe starWars = new testing.Universe("starWars", new ArrayList<>());
        testing.Universe hitchhikers = new testing.Universe("hitchHiker", new ArrayList<>());
        testing.Universe marvel = new testing.Universe("marvel", new ArrayList<>());
        testing.Universe rings = new testing.Universe("rings", new ArrayList<>());


        for (JsonNode entry : data) {
            testing.Individual individual = new testing.Individual(entry);
            System.out.println(individual.getAge() + "\n");

        }

        mapper.writeValue(new File("src/main/resources/output/starwars.json"), starWars);
        mapper.writeValue(new File("src/main/resources/output/hitchhiker.json"), hitchhikers);
        mapper.writeValue(new File("src/main/resources/output/rings.json"), rings);
        mapper.writeValue(new File("src/main/resources/output/marvel.json"), marvel);
    }
}

record Universe(
        String name,
        List<JsonNode> individuals
) { }