package oop.task3;

public class Coffee {
    private Intensity intensity;
    private final String name = "Coffee";

    public Intensity getIntensity() {
        return intensity;
    }

    public Coffee(Intensity intensity) {
        this.intensity = intensity;
    }


    void printCoffeeDetails() {
        System.out.println("----------");
        System.out.println(name + " intensity: " + intensity.toString());
    }
}
