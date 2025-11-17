
package org.example;

import java.util.*;

    public class UserInterface {

        private final Scanner scanner = new Scanner(System.in);

        public void start() {
            boolean running = true;

            while (running) {
                System.out.println("\n=== Welcome to DELI-cious ===");
                System.out.println("1) New Order");
                System.out.println("0) Exit");
                System.out.print("Enter choice: ");

                switch (scanner.nextLine()) {
                    case "1" -> handleNewOrder();
                    case "0" -> {
                        System.out.println("Goodbye!");
                        running = false;
                    }
                    default -> System.out.println("Invalid selection.");
                }
            }
        }

        private void handleNewOrder() {
            Order order = new Order();
            boolean ordering = true;

            while (ordering) {
                System.out.println("\n--- Order Menu ---");
                System.out.println("1) Add Sandwich");
                System.out.println("2) Add Drink");
                System.out.println("3) Add Chips");
                System.out.println("4) Checkout");
                System.out.println("0) Cancel Order");
                System.out.print("Enter choice: ");

                switch (scanner.nextLine()) {
                    case "1" -> order.addSandwich(buildSandwich());
                    case "2" -> order.addDrink(buildDrink());
                    case "3" -> order.addChips(buildChips());
                    case "4" -> {
                        if (!orderHasValidItems(order)) {
                            System.out.println("Order must contain at least one item.");
                        } else {
                            checkout(order);
                            ordering = false;
                        }
                    }
                    case "0" -> {
                        System.out.println("Order canceled.");
                        ordering = false;
                    }
                    default -> System.out.println("Invalid selection.");
                }
            }
        }

        private Sandwich buildSandwich() {

            // Bread
            System.out.println("\nSelect bread:");
            BreadType bread = chooseEnum(BreadType.values());

            // Size
            System.out.println("\nSelect sandwich size:");
            SandwichSize size = chooseEnum(SandwichSize.values());

            // Toasted?
            System.out.print("Toasted? (y/n): ");
            boolean toasted = readYesNo();

            Sandwich sandwich = new Sandwich(bread, size, toasted);

            // Toppings loop
            boolean addingToppings = true;
            while (addingToppings) {
                System.out.println("\nAdd topping category:");
                System.out.println("1) Meat");
                System.out.println("2) Cheese");
                System.out.println("3) Regular");
                System.out.println("4) Sauce");
                System.out.println("0) Done");
                System.out.print("Choose: ");

                switch (scanner.nextLine()) {

                    case "1" -> addToppingFromList(sandwich, ToppingMenu.meats, ToppingType.meat);
                    case "2" -> addToppingFromList(sandwich, ToppingMenu.cheeses, ToppingType.cheese);
                    case "3" -> addToppingFromList(sandwich, ToppingMenu.regulars, ToppingType.regular);
                    case "4" -> addToppingFromList(sandwich, ToppingMenu.sauces, ToppingType.sauce);

                    case "0" -> addingToppings = false;

                    default -> System.out.println("Invalid selection.");
                }
            }

            return sandwich;
        }


        private void addToppingFromList(Sandwich sandwich, List<String> list, ToppingType type) {

            System.out.println("\nChoose topping:");
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d) %s%n", i + 1, list.get(i));
            }
            System.out.print("Choose: ");

            int choice = readInt(1, list.size());
            String name = list.get(choice - 1);

            boolean extra = false;
            if (type == ToppingType.cheese || type == ToppingType.meat) {
                System.out.print("Extra? (y/n): ");
                extra = readYesNo();
            }

            sandwich.addTopping(new Topping(name, 0, type, extra));
            System.out.println(name + " added.");
        }

        private Drink buildDrink() {
            System.out.println("\nSelect drink flavor:");
            DrinkFlavor flavor = chooseEnum(DrinkFlavor.values());

            System.out.println("\nSelect drink size:");
            DrinkSize size = chooseEnum(DrinkSize.values());

            return new Drink(flavor, size);
        }

        private Chips buildChips() {
            System.out.println("\nSelect chips:");
            ChipType type = chooseEnum(ChipType.values());
            return new Chips(type);
        }

        private void checkout(Order order) {
            System.out.println("\n" + order);
            System.out.print("Confirm order? (y/n): ");

            if (readYesNo()) {
                FileManager.saveReceipt(order);
                System.out.println("Order complete! Returning to home.");
            } else {
                System.out.println("Order canceled.");
            }
        }

        private boolean orderHasValidItems(Order order) {
            return !order.getSandwiches().isEmpty()
                    || !order.getDrinks().isEmpty()
                    || !order.getChips().isEmpty();
        }

        private boolean readYesNo() {
            while (true) {
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("y")) return true;
                if (input.equals("n")) return false;
                System.out.print("Please enter y or n: ");
            }
        }

        private int readInt(int min, int max) {
            while (true) {
                try {
                    int value = Integer.parseInt(scanner.nextLine());
                    if (value >= min && value <= max) return value;
                } catch (Exception ignored) {}
                System.out.print("Enter a number between " + min + " and " + max + ": ");
            }
        }

        private <T extends Enum<T>> T chooseEnum(T[] values) {
            for (int i = 0; i < values.length; i++) {
                System.out.printf("%d) %s%n", i + 1, values[i].toString());
            }
            int choice = readInt(1, values.length);
            return values[choice - 1];
        }
    }


