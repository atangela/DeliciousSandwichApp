package org.example;

public class Chips {
    private ChipType type;
    private double price = 1.50;

    public Chips(ChipType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public ChipType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + " chips - $" + price;
    }
}
