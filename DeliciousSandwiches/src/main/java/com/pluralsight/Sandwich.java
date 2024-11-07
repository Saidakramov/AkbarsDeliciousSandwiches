package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String breadType;  // "white", "wheat", "rye", "wrap"
    private String size;  // "4", "8", or "12"
    private boolean toasted;
    private List<Toppings> regularToppings;
    private List<Toppings> premiumToppings;

    public Sandwich(String breadType, String size, boolean toasted, List<Toppings> regularToppings, List<Toppings> premiumToppings) {
        this.breadType = breadType;
        this.size = size;
        this.toasted = toasted;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
    }

    public void addTopping(Toppings topping) {
        if (topping.isPremium()) {
            premiumToppings.add(topping);
        } else {
            regularToppings.add(topping);
        }
    }

    public double cost() {
        double baseCost = size.equals("4") ? 5.5 : size.equals("8") ? 7.0 : 8.5;
        double premiumCost = premiumToppings.stream()
                .mapToDouble(Toppings::getExtraCost).sum();
        return baseCost + premiumCost;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", size='" + size + '\'' +
                ", toasted=" + toasted +
                ", regularToppings=" + regularToppings +
                ", premiumToppings=" + premiumToppings +
                '}';
    }
}
