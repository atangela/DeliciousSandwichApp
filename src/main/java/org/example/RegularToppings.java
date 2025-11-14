package org.example;

public enum RegularToppings {
    lettuce("Lettuce"),
    peppers("Peppers"),
    onions("Onions"),
    tomatoes("Tomatoes"),
    jalapenos("Jalapenos"),
    cucumbers("Cucumbers"),
    pickles("Pickles"),
    guacamole("Guacamole"),
    mushrooms("Mushrooms");

    private String displayName;

    RegularToppings(String displayName) { this.displayName = displayName; }

    public String getDisplayName() { return displayName; }
}
