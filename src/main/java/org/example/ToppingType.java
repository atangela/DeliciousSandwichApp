package org.example;

public enum ToppingType {
    meat("Meat"),
    cheese("Cheese"),
    regular("Regular"),
    sauce("Sauce");

    private String displayName;

    ToppingType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
