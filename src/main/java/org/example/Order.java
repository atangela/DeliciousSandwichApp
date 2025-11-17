package org.example;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches = new ArrayList<>();
    private List<Drink> drinks = new ArrayList<>();
    private List<Chips> chips = new ArrayList<>();

    public void addSandwich(Sandwich sandwich) { sandwiches.add(sandwich); }
    public void addDrink(Drink drink) { drinks.add(drink); }
    public void addChips(Chips chip) { chips.add(chip); }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public double calculateTotal() {
        double sandwichTotal = sandwiches.stream().mapToDouble(Sandwich::calculatePrice).sum();
        double drinkTotal = drinks.stream().mapToDouble(Drink::getPrice).sum();
        double chipsTotal = chips.stream().mapToDouble(Chips::getPrice).sum();
        return sandwichTotal + drinkTotal + chipsTotal;
    }

    public boolean isValid() {
        if (!sandwiches.isEmpty()) return true;
        return !drinks.isEmpty() || !chips.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("\n------Order Details------\n");
        sandwiches.forEach(sandwich -> stringBuilder.append(sandwich).append("\n"));
        drinks.forEach(drink -> stringBuilder.append(drink).append("\n"));
        chips.forEach(chips -> stringBuilder.append(chips).append("\n"));
        stringBuilder.append(String.format("Total: $%.2f\n", calculateTotal()));
        return stringBuilder.toString();
    }
}
