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
        return size.getDisplayName() + " " + flavor.getDisplayName() + " - $" + getPrice();
    }
}
