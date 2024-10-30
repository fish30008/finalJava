package oop;


public class PumpkinSpiceLatte extends Cappuccino {

    private final String name = "Pumpkin Spice Latte";
    private SyrupType syrup;
    private int mgOfPumpkinSpice;
    public PumpkinSpiceLatte(Intensity intensity, int mlOfMilk, int mgOfPumpkinSpice) {
        super(intensity, mlOfMilk);
        this.mgOfPumpkinSpice = mgOfPumpkinSpice;
    }
    @Override
    void printCoffeeDetails() {
        super.printCoffeeDetails();
        System.out.println(name + " idk what is that " + mgOfPumpkinSpice + " mg ");
    }
}
