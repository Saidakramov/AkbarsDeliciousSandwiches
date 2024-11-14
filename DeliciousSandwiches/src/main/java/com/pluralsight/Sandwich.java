package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private final String breadType;  // "white", "wheat", "rye", "wrap"
    private final int size;  // "4", "8", or "12"
    private boolean toasted;
    private final List<Toppings> regularToppings;
    private final List<Toppings> premiumToppings;
    private final List<String> sauces;
    private final List<String> sides;
    private int extraMeat;
    private int extraCheese;

    public Sandwich(String breadType, int size) {
        this.breadType = breadType;
        this.size = size;
        this.regularToppings = new ArrayList<>();
        this.premiumToppings = new ArrayList<>();
        this.sauces = new ArrayList<>();
        this.sides = new ArrayList<>();
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

    public void addSauce(String sauce) {
        sauces.add(sauce);
    }

    public void addSide(String side) {
        sides.add(side);
    }

    public double calculateCost() {
        double baseCost = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0;
        };

        double premiumCost = premiumToppings.stream().mapToDouble(t -> t.getPrice(size)).sum();

        double extraMeatCost = extraMeat * (size == 4 ? 0.50 : size == 8 ? 1.00 : 1.50);

        double extraCheeseCost = extraCheese * (size == 4 ? 0.30 : size == 8 ? 0.60 : 0.90);

        return baseCost + premiumCost + extraMeatCost + extraCheeseCost;
    }

    public String displaySandwichCost() {
        StringBuilder stringBuilder = new StringBuilder();
        double baseCost = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0;
        };
        stringBuilder.append("Base Cost: $").append(baseCost).append("\n");

        double premiumCost = premiumToppings.stream().mapToDouble(t -> t.getPrice(size)).sum();
        stringBuilder.append("Premium Toppings Cost: $").append(premiumCost).append("\n");

        double extraMeatCost = extraMeat * (size == 4 ? 0.50 : size == 8 ? 1.00 : 1.50);
        if (extraMeatCost != 0) {
            stringBuilder.append("Extra Meat Cost: $").append(extraMeatCost).append("\n");
        }

        double extraCheeseCost = extraCheese * (size == 4 ? 0.30 : size == 8 ? 0.60 : 0.90);
        if (extraCheeseCost != 0) {
            stringBuilder.append("Extra Cheese Cost: $").append(extraCheeseCost).append("\n");
        }

        double totalCost = baseCost + premiumCost + extraMeatCost + extraCheeseCost;
        stringBuilder.append("Total Sandwich Cost: $").append(totalCost).append("\n");
        return stringBuilder.toString();
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", \nsize=" + size +
                ", \ntoasted=" + toasted +
                ", \nregularToppings=" + regularToppings +
                ", \npremiumToppings=" + premiumToppings +
                ", \nsauces=" + sauces +
                ", \nsides=" + sides +
                ", \nextraMeat=" + extraMeat +
                ", \nextraCheese=" + extraCheese +
                '}';
    }
}
