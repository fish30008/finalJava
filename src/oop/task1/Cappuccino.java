package oop.task1;


public class Cappuccino extends Coffee {

    private final String name = "Cappuccino";
    private int mlOfMilk;

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }
}
