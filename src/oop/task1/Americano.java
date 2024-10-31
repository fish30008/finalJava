package oop.task1;

public class Americano extends Coffee {

    private final String name = "Americano";
    private int mlOfWater;

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }

}
