package oop.task3;


public class Americano extends Coffee {

    private final String name = "Americano";
    private int mlOfWater;

    public Americano(Intensity intensity, int mlOfWater) {
        super(intensity);
        this.mlOfWater = mlOfWater;
    }

    @Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("Making " + name);
        System.out.println("Adding water " + mlOfWater + " ml");
    }

    public final Americano makeAmericano() {
        printCoffeeDetails();
        return this;
    }
}
