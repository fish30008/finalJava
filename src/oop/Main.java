package oop;
public class Main {
    public static void main(String[] args) {
        Display display = new Display("Asus", 50, 50, 1080);
        Display display1 = new Display("Lenovo", 1250, 5320, 1080);
       display.compareSize(display1);
    }
}