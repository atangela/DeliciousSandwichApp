package org.example;

public class Drink {
    private DrinkFlavor flavor;
    private DrinkSize size;

    public Drink(DrinkFlavor flavor, DrinkSize size) {
        this.flavor = flavor;
        this.size = size;
    }

    public double getPrice() {
        return size.getPrice();
    }

    @Override
    public String toString() {
        return String.format("%s %s - $%.2f",
                size.getDisplayName(),
                flavor.getDisplayName(),
                getPrice());
    }
}
