package oop;

import oop.task4.Barista;
import oop.task4.Intensity;
import oop.task4.SyrupType;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Barista barista = new Barista();
        HashMap<String, Map<String, Object>> coffeeOrders = new HashMap<>();

        while (true) {
            System.out.println("Select coffee type:1 - Americano, 2 - Cappuccino, 3 - SyrupCappuccino, 4 - Pumpkin Spice Latte, 5 - Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 5) break;

            Map<String, Object> params = new HashMap<>();
            switch (choice) {
                case 1:
                    System.out.println("You selected Americano.");
                    System.out.print("Enter intensity (LIGHT, NORMAL, STRONG): ");
                    params.put("intensity", Intensity.valueOf(scanner.nextLine().toUpperCase()));
                    System.out.print("Enter ml of water: ");
                    params.put("mlOfWater", scanner.nextInt());
                    scanner.nextLine();  // Consume newline
                    coffeeOrders.put("americano", params);
                    break;

                case 2:
                    System.out.println("You selected Cappuccino.");
                    System.out.print("Enter intensity (LIGHT, NORMAL, STRONG): ");
                    params.put("intensity", Intensity.valueOf(scanner.nextLine().toUpperCase()));
                    System.out.print("Enter ml of milk: ");
                    params.put("mlOfMilk", scanner.nextInt());
                    scanner.nextLine();  // Consume newline
                    coffeeOrders.put("Cappuccino", params);
                    break;

                case 3:
                    System.out.println("You selected SyrupCappuccino.");
                    System.out.print("Enter intensity (LIGHT, NORMAL, STRONG): ");
                    params.put("intensity", Intensity.valueOf(scanner.nextLine().toUpperCase()));
                    System.out.print("Enter ml of milk: ");
                    params.put("mlOfMilk", scanner.nextInt());
                    System.out.print("Enter SyrupType (MACADAMIA, VANILLA, COCONUT, CARAMEL, CHOCOLATE, POPCORN) :");
                    params.put("intensity", SyrupType.valueOf(scanner.nextLine().toUpperCase()));
                    scanner.nextLine();  // Consume newline
                    coffeeOrders.put("SyrupCappucino", params);
                    break;

                case 4:
                    System.out.println("You selected PumpkinSpiceLatte.");
                    System.out.print("Enter intensity (LIGHT, NORMAL, STRONG): ");
                    params.put("intensity", Intensity.valueOf(scanner.nextLine().toUpperCase()));
                    System.out.print("Enter ml of milk: ");
                    params.put("mlOfMilk", scanner.nextInt());
                    System.out.print("Enter mg of PumpkinSpice: ");
                    params.put("mgOfPumpkinSpice", scanner.nextInt());
                    scanner.nextLine();  // Consume newline
                    coffeeOrders.put("PumpkinSpiceLatte", params);
                    break;

                default:
                    System.out.println("Invalid selection.");
            }
        }
        // Prepare all coffee orders
        barista.prepareMultipleCoffees(coffeeOrders);
        scanner.close();
    }
}
