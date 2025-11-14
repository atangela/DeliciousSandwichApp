package org.example;

public enum Sauce {
    mayo("Mayo"),
    mustard("Mustard"),
    ketchup("Ketchup"),
    ranch("Ranch"),
    thousandIslands("Thousand Islands"),
    vinaigrette("Vinaigrette");

    private String displayName;

    Sauce(String displayName) { this.displayName = displayName; }

    public String getDisplayName() { return displayName; }
}
