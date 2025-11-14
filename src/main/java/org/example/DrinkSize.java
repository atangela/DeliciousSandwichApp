package org.example;

public enum DrinkSize {
    small("Small", 2.00),
    medium("Medium", 2.50),
    large("Large", 3.00);

    private String displayName;
    private double price;

    DrinkSize(String displayName, double price) {
        this.displayName = displayName;
        this.price = price;
    }

    public String getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return displayName + " ($" + price + ")";
    }
}
