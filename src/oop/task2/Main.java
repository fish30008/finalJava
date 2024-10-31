package oop.task2;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new Coffee(Intensity.STRONG);
        coffee.printCoffeeDetails();
        Coffee americano = new Americano(Intensity.LIGHT, 50);
        americano.printCoffeeDetails();
    }}
//    Coffee syrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, 150, SyrupType.COCONUT);
//    syrupCappuccino.printCoffeeDetails();
//
//    Coffee pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 20, 100);
//    pumpkinSpiceLatte.printCoffeeDetails();

