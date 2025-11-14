package org.example;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\nWelcome to DELI-cious Sandwiches");
            System.out.println("1. New Order");
            System.out.println("0. Exit");
            System.out.println("Please select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> startNewOrder();
                case "2" -> running = false;
                default -> System.out.println("Please enter 1 or 0.");
            }
        }
        System.out.println("Thank you!");
        }

        private static void startNewOrder() {
        Order order = new Order();
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n1. Add Sandwich");
            System.out.println("2. Add Drink");
            System.out.println("3. Add Chips");
            System.out.println("4. Checkout");
            System.out.println("0. Cancel Order");
            System.out.print("Please select a choice: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> order.addSandwich(createSandwich());
                case "2" -> order.addDrink(createDrink());
                case "3" -> order.addChips(createChips());
                case "4" -> checkout(order);
                case "0" -> {
                    System.out.println("Order cancelled."); return;
                }
                default -> System.out.println("Please select another option.");
            }
        }
        }

        private static Sandwich createSandwich() {
            System.out.print("Choose bread (white, wheat, rye, wrap): ");
            BreadType bread = BreadType.valueOf(scanner.nextLine().trim().toUpperCase());

            System.out.print("Choose size (4, 8, 12): ");
            SandwichSize size = switch (scanner.nextLine()) {
                case "4" -> SandwichSize.fourInch;
                case "8" -> SandwichSize.eightInch;
                case "12" -> SandwichSize.twelveInch;
                default -> SandwichSize.fourInch;
            };

            System.out.println("Toasted? (y/n): ");
            boolean toasted = scanner.nextLine().equalsIgnoreCase("y");

            Sandwich sandwich = new Sandwich(bread, size, toasted);

            System.out.println("Add toppings (type 'done' to finish): ");
            while (true) {
                System.out.print("Enter topping name: ");
                String topping = scanner.nextLine();
                if (topping.equalsIgnoreCase("done")) break;
                sandwich.addTopping(new Topping(topping, 0.0) {});
            }
            return sandwich;
        }

        private static void chooseMeats(Sandwich sandwich) {
            System.out.println("\nChoose meat toppings:");
            int i = 1;
            for (MeatTopping meatTopping : MeatTopping.values()) {
                System.out.println(i++ + ") " + meatTopping.getDisplayName());
            }
            System.out.println("0. Done");

            while (true) {
                System.out.print("Choose a meat: ");
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice == 0) break;

                MeatTopping selected = MeatTopping.values()[choice - 1];

                System.out.print("Extra? (y/n): ");
                boolean extra = scanner.nextLine().equalsIgnoreCase("y");

                sandwich.addTopping(
                        new Topping(selected.getDisplayName(), ToppingType.meat, extra)
                );
            }
        }



    private static Drink createDrink() {
        System.out.println("\nChoose a drink flavor:");
        int i = 1;
        for (DrinkFlavor flavor : DrinkFlavor.values()) {
            System.out.println(i++ + ") " + flavor.getDisplayName());
        }
        System.out.print("Please select a choice: ");
        int flavorChoice = Integer.parseInt(scanner.nextLine());
        DrinkFlavor selectedFlavor = DrinkFlavor.values()[flavorChoice - 1];

        System.out.println("\nChoose a drink size:");
        int j = 1;
        for (DrinkSize size : DrinkSize.values()) {
            System.out.println(j++ + ") " + size.getDisplayName() + " ($" + size.getPrice() + ")");
        }
        System.out.print("Please select a choice: ");
        int sizeChoice = Integer.parseInt(scanner.nextLine());
        DrinkSize selectedSize = DrinkSize.values()[sizeChoice - 1];

        Drink drink = new Drink(selectedFlavor, selectedSize);
        System.out.println(selectedSize.getDisplayName() + " " + selectedFlavor.getDisplayName() + "added.");
        return drink;
    }

private static Chips createChips() {
    System.out.println("\nChoose a chip type:");
    int i = 1;
    for (ChipType chipType : ChipType.values()) {
        System.out.println(i++ + ") " + chipType.getDisplayName());
    }
    System.out.print("Please select a choice: ");
    int choice = Integer.parseInt(scanner.nextLine());
    ChipType selected = ChipType.values()[choice - 1];

    Chips chips = new Chips(selected);
    System.out.println(selected.getDisplayName() + " chips added.");
    return chips;
}

private static void checkout(Order order) {
    System.out.println(order);
    System.out.print("Confirm order? (y/n): ");
    if (scanner.nextLine().equalsIgnoreCase("y")) {
        FileManager.saveReceipt(order);
    } else {
        System.out.println("Order cancelled.");
    }
}
}