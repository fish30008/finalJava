package testing;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.ArrayList;
import java.util.List;

public class OwnClassifier {
    private String universe;
    private Boolean isHumanoid;
    private Integer age;
    private List<String> traits;

    public OwnClassifier(JsonNode entry) {
        this.universe = entry.get("universe").asText();
        this.isHumanoid = entry.get("isHumanoid").asBoolean();
        this.age = entry.get("age").asInt();
        this.traits = new ArrayList<>();
        for (JsonNode trait : entry.get("traits")) {
            this.traits.add(trait.asText());
        }
    }

    public boolean matches(testing.Individual individual) {
        if (individual.getTraits() != null && !individual.getTraits().isEmpty()) {
            for (String individualTrait : individual.getTraits()) {
                if (this.traits.contains(individualTrait)) {
                    return true;
                }
            }
        }
        if (this.isHumanoid != null && this.isHumanoid.equals(individual.isHumanoid())) {
            if (this.age != null && individual.getAge() != null && individual.getAge() <= this.age) {
                return true;
            }
        }
        return false;
    }

    public String getUniverse() {
        return universe;
    }
    public void saveToJson(testing.Individual individual) {
        testing.PlanetJsonSaver saver = new testing.PlanetJsonSaver(this.universe);
        saver.saveToJson(individual);
    }
}
