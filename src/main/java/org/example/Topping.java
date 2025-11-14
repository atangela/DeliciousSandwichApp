package org.example;

public class Topping {
    protected String name;
    protected double price;
    private ToppingType type;
    private boolean isExtra;

    public Topping(String name, double price, ToppingType type, boolean isExtra) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.isExtra = isExtra;
    }

    public Topping(String topping, double price) {
    }

    public Topping(String displayName, ToppingType toppingType, boolean extra) {
    }

    public String getName() { return name; }
    public double getPrice(SandwichSize size) {
        if (type == ToppingType.regular || type == ToppingType.sauce) return 0.0;

        return switch (type) {
            case meat -> isExtra ?
                    switch (size) {
                        case fourInch -> 0.50;
                        case eightInch -> 1.00;
                        case twelveInch -> 1.50;
                    }
                    :
                    switch (size) {
                        case fourInch -> 1.00;
                        case eightInch -> 2.00;
                        case twelveInch -> 3.00;
                    };

            case cheese -> isExtra ?
                    switch (size) {
                        case fourInch -> 0.30;
                        case eightInch -> 0.60;
                        case twelveInch -> 0.90;
                    }
                    :
                    switch (size) {
                        case fourInch -> 0.75;
                        case eightInch -> 1.50;
                        case twelveInch -> 2.25;
                    };
            default -> 0.0;
        };
    }
    public ToppingType getType() { return type; }
    public boolean isExtra() { return isExtra; }

    @Override
    public String toString() {
        return name + (isExtra ? " (extra)" : "");
    }
}
