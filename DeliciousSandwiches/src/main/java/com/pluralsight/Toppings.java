package com.pluralsight;

public class Toppings {
    private String name;
    private boolean isPremium;
    private double extraCost;

    public Toppings(String name, boolean isPremium, double extraCost) {
        this.name = name;
        this.isPremium = isPremium;
        this.extraCost = extraCost;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public double getExtraCost() {
        return extraCost;
    }

}
