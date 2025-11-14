package org.example;

public enum ChipType {
    nachoCheese("Nacho Cheese"),
    coolRanch("Cool Ranch"),
    sweetHeatBBQ("Sweet Heat BBQ"),
    sourCream("Sour Cream & Onion");

    private String displayName;

    ChipType(String displayName) {
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
