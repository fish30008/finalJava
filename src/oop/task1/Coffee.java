package oop.task1;


public class Coffee {
    private Intensity intensity;
    private final String name = "Coffee" ;

    public Intensity getIntensity() {
        return intensity;
    }

    public Coffee(Intensity intensity) {
        this.intensity = intensity;
    }

}
