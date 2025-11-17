package org.example;

public enum BreadType {
    white("White"),
    wheat("Wheat"),
    rye("Rye"),
    wrap("Wrap");

    private String displayName;

    BreadType(String displayName) {
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
