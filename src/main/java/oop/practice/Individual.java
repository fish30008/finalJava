package oop.practice;
import java.util.List;
class Individual {
    private int id;
    private Boolean isHumanoid;
    private Integer age; // Use Integer instead of int
    private List<String> traits;
    private Planet planet;
    // Enum for Planets
    enum Planet {
        Earth,
        Asgard,
        Betelgeuse,
        Vogsphere,
        Kashyyyk,
        Endor
    }
    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Boolean getIsHumanoid() {
        return isHumanoid;
    }
    public void setHumanoid(Boolean humanoid) {
        isHumanoid = humanoid;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) { // Change to Integer
        this.age = age;
    }
    public List<String> getTraits() {
        return traits;
    }
    public void setTraits(List<String> traits) {
        this.traits = traits;
    }
    public Planet getPlanet() {
        return planet;
    }
    public void setPlanet(Planet planet) {
        this.planet = planet;
    }
}