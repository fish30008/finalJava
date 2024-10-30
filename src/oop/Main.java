package oop;

public class Main {
    public static void main(String[] args) {
    Coffee coffee = new Coffee(Intensity.STRONG);
    coffee.printCoffeeDetails();
    Americano americano = new Americano(Intensity.LIGHT, 50);
    americano.printCoffeeDetails();

    SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, 150, SyrupType.COCONUT);
    syrupCappuccino.printCoffeeDetails();

    PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 20, 100);
    pumpkinSpiceLatte.printCoffeeDetails();
}}
