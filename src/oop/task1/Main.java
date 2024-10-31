package oop.task1;


public class Main {
    public static void main(String[] args) {
    Coffee coffee = new Coffee(Intensity.STRONG);
    Americano americano = new Americano(Intensity.LIGHT, 50);

    SyrupCappuccino syrupCappuccino = new SyrupCappuccino(Intensity.NORMAL, 150, SyrupType.COCONUT);

    PumpkinSpiceLatte pumpkinSpiceLatte = new PumpkinSpiceLatte(Intensity.NORMAL, 20, 100);

}}
