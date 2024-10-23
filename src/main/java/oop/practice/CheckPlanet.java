package testing;

import com.fasterxml.jackson.databind.JsonNode;

public class CheckPlanet {

    private String universe;
    private String planet;

    public CheckPlanet(JsonNode entry) {
        this.planet = entry.get("planet").asText();
        this.universe = entry.get("universe").asText();
    }

    public boolean matchPlanet(testing.Individual individual) {
        // Match based on planet
        return individual.getPlanet() != null && individual.getPlanet().equals(this.planet);
    }

    public void saveToJson(testing.Individual individual) {
        testing.PlanetJsonSaver saver = new testing.PlanetJsonSaver(this.universe);
        saver.saveToJson(individual);
    }
}
