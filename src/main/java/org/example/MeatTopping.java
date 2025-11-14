package org.example;

public enum MeatTopping {
    steak("Steak"),
    ham("Ham"),
    salami("Salami"),
    roastBeef("Roast Beef"),
    chicken("Chicken"),
    bacon("Bacon");

    private String displayName;

    MeatTopping(String displayName) { this.displayName = displayName; }

    public String getDisplayName() { return displayName; }
}
