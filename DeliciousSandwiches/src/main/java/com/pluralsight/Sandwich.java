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

    public double calculateCost() {
        double baseCost = switch (size) {
            case 4 -> 5.50;
            case 8 -> 7.00;
            case 12 -> 8.50;
            default -> 0;
        };
        System.out.println("Base Cost: $" + baseCost);

        double premiumCost = premiumToppings.stream().mapToDouble(t -> t.getPrice(size)).sum();
        System.out.println("Premium Toppings Cost: $" + premiumCost);

        double extraMeatCost = extraMeat * (size == 4 ? 0.50 : size == 8 ? 1.00 : 1.50);
        if (extraMeatCost != 0) {
            System.out.println("Extra Meat Cost: $" + extraMeatCost);
        }

        double extraCheeseCost = extraCheese * (size == 4 ? 0.30 : size == 8 ? 0.60 : 0.90);
        if (extraCheeseCost != 0) {
            System.out.println("Extra Cheese Cost: $" + extraCheeseCost);
        }

        double totalCost = baseCost + premiumCost + extraMeatCost + extraCheeseCost;
        System.out.println("Total Sandwich Cost: $" + totalCost);
        return totalCost;
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
