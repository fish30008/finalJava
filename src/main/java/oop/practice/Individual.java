package testing;

import com.fasterxml.jackson.databind.JsonNode;
import java.util.List;
import java.util.ArrayList;

public class Individual {

    //use wrapper because it can handle null values
    private Integer id;
    private Boolean isHumanoid;
    private Integer age;
    private List<String> traits;
    private String planet;

    //handle null values
    public Individual(JsonNode entry) {
        if (entry.get("id") != null) {
            this.id = entry.get("id").asInt();
        } else {
            this.id = null;
        }

        if (entry.get("isHumanoid") != null) {
            this.isHumanoid = entry.get("isHumanoid").asBoolean();
        } else {
            this.isHumanoid = null;
        }
        if (entry.get("age") != null) {
            this.age = entry.get("age").asInt();
        } else {
            this.age = null;
        }
        this.traits = new ArrayList<>();
        if (entry.get("traits")!=null) {
            for (JsonNode trait : entry.get("traits")) {
                this.traits.add(trait.asText());
            }
        } else {
            this.traits = null;
        }
        this.planet = entry.hasNonNull("planet") ? entry.get("planet").asText() : null;

    }

    //to get values
    public Integer getId() {
        return id;
    }

    public Boolean isHumanoid() {
        return isHumanoid;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getTraits() {
        return traits;
    }

    public String getPlanet() {
        return planet;
    }

}
