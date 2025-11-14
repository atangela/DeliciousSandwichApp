package org.example;

public enum CheeseTopping {
    american("American"),
    provolone("Provolone"),
    cheddar("Cheddar"),
    swiss("Swiss");

    private String displayName;

    CheeseTopping(String displayName) { this.displayName = displayName; }

    public String getDisplayName() { return displayName; }
}
