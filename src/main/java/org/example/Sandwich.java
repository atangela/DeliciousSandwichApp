package org.example;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private BreadType breadType;
    private SandwichSize size;
    private boolean toasted;
    private List<Topping> toppings = new ArrayList<>();

    public Sandwich(BreadType breadType, SandwichSize size, boolean toasted) {
        this.breadType = breadType;
        this.size = size;
        this.toasted = toasted;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double calculatePrice() {
        double basePrice = switch (size) {
            case fourInch -> 5.50;
            case eightInch -> 7.00;
            case twelveInch -> 8.50;
        };
        double toppingTotal = toppings.stream().mapToDouble(toppings -> toppings.getPrice(size)).sum();
        return basePrice + toppingTotal;
    }

    @Override
    public String toString() {
        return String.format("%s\" %s sandwich%s with toppings: %s",
                size.getLength(),
                breadType.name(),
                toasted ? " (toasted)" : "",
                toppings.isEmpty() ? "none" : toppings);
    }
}
