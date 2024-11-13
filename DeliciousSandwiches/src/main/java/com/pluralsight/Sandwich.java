package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String breadType;  // "white", "wheat", "rye", "wrap"
    private int size;  // "4", "8", or "12"
    private boolean toasted;
    private List<Toppings> regularToppings;
    private List<Toppings> premiumToppings;
    private List<String> sauces;
    private List<String> sides;
    private int extraMeat;
    private int extraCheese;

    public Sandwich(String breadType, int size, boolean toasted) {
        this.breadType = breadType;
        this.size = size;
        this.toasted = toasted;
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
        System.out.println("Extra Meat Cost: $" + extraMeatCost);

        double extraCheeseCost = extraCheese * (size == 4 ? 0.30 : size == 8 ? 0.60 : 0.90);
        System.out.println("Extra Cheese Cost: $" + extraCheeseCost);

        double totalCost = baseCost + premiumCost + extraMeatCost + extraCheeseCost;
        System.out.println("Total Sandwich Cost: $" + totalCost);
        return totalCost;
    }

    @Override
    public String toString() {
        return "Sandwich{" +
                "breadType='" + breadType + '\'' +
                ", size=" + size +
                ", toasted=" + toasted +
                ", regularToppings=" + regularToppings +
                ", premiumToppings=" + premiumToppings +
                ", sauces=" + sauces +
                ", sides=" + sides +
                ", extraMeat=" + extraMeat +
                ", extraCheese=" + extraCheese +
                '}';
    }
}
