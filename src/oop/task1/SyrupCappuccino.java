package oop.task1;

public class SyrupCappuccino extends Cappuccino {

    private final String name = "Cappuccino";
    private SyrupType syrup;

    public SyrupCappuccino(Intensity intensity, int mlOfMilk, SyrupType syrup) {
        super(intensity, mlOfMilk);
        this.syrup = syrup;
    }
}
