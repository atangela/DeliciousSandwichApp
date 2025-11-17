package org.example;

public enum SandwichSize {
    fourInch(4, 5.50),
    eightInch(8, 7.00),
    twelveInch(12, 8.50);

    private int length;
    private double basePrice;

    SandwichSize(int length, double basePrice) {
        this.length = length;
        this.basePrice = basePrice;
    }

    public int getLength() {
        return length;
    }

    public double getBasePrice() {
        return basePrice;
    }

    @Override
    public String toString() {
        return length + "\"";
    }
}
