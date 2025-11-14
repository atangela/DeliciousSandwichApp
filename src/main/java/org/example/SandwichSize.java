package org.example;

public enum SandwichSize {
    fourInch(4),
    eightInch(8),
    twelveInch(12);

    private int length;
    SandwichSize(int length) { this.length = length; }
    public int getLength() { return length; }
}
