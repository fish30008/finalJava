package oop.task3;

public class Main {
    public static void main(String[] args) {
    Coffee coffee = new Coffee(Intensity.STRONG);
    coffee.printCoffeeDetails();
    Coffee americano = new Americano(Intensity.LIGHT, 50).makeAmericano();

    Coffee cappuccino = new Cappuccino(Intensity.LIGHT, 50).makeCappuccino();


//    SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, 150, SyrupType.COCONUT);
//    syrupCappuccino.printCoffeeDetails();
//
//    PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 20, 100);
//    pumpkinSpiceLatte.printCoffeeDetails();
}}
