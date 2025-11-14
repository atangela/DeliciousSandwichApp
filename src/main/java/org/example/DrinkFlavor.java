package org.example;

public enum DrinkFlavor {
    water("Water"),
    lemonade("Lemonade"),
    fruitPunch("Fruit Punch"),
    sweetTea("Sweet Tea");

    private String displayName;

    DrinkFlavor(String displayName) {
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
