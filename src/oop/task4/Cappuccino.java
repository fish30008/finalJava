package oop.task4;


public class Cappuccino extends Coffee{

    private final String name = "Cappuccino";
    private int mlOfMilk;

    public Cappuccino(Intensity intensity, int mlOfMilk) {
        super(intensity);
        this.mlOfMilk = mlOfMilk;
    }
    @Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println("added " + " milk " + mlOfMilk + " ml ");
    }
    public final Cappuccino makeCappucino() {
        printCoffeeDetails();
        return this;
    }
}
