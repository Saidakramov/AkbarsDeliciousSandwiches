package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String breadType;  // "white", "wheat", "rye", "wrap"
    private String size;  // "4", "8", or "12"
    private boolean toasted;
    private List<Toppings> regularToppings;
    private List<Toppings> premiumToppings;
    private int extraMeat;
    private int extraCheese;

    public Sandwich(String breadType, String size, boolean toasted) {
        this.breadType = breadType;
        this.size = size;
        this.toasted = toasted;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.extraMeat = 0;
        this.extraCheese = 0;
    }

    public void addTopping(Toppings topping) {
        if (topping.isPremium()) {
            premiumToppings.add(topping);
        } else {
            regularToppings.add(topping);
        }
    }

    public void addExtraMeat() {
        extraMeat++;
    }

    public void addExtraCheese() {
        extraCheese++;
    }

    public double calculateCost() {
        double baseCost = switch (size) {
            case "4" -> 5.50;
            case "8" -> 7.00;
            case "12" -> 8.50;
            default -> 0;
        };

        double premiumCost = premiumToppings.stream().mapToDouble(t -> t.getPrice(size)).sum();
        double extraMeatCost = extraMeat * (size.equals("4") ? 0.50 : size.equals("8") ? 1.00 : 1.50);
        double extraCheeseCost = extraCheese * (size.equals("4") ? 0.30 : size.equals("8") ? 0.60 : 0.90);

        return baseCost + premiumCost + extraMeatCost + extraCheeseCost;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", size='" + size + '\'' +
                ", toasted=" + toasted +
                ", regularToppings=" + regularToppings +
                ", premiumToppings=" + premiumToppings +
                ", extraMeat=" + extraMeat +
                ", extraCheese=" + extraCheese +
                '}';
    }
}
