package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private int smallDrink;
    private int mediumDrink;
    private int largeDrink;
    private int chips;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.smallDrink = 0;
        this.mediumDrink = 0;
        this.largeDrink = 0;
        this.chips = 0;
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(String size) {
        switch (size) {
            case "small": smallDrink ++; break;
            case "medium": mediumDrink++; break;
            case "large": largeDrink++; break;
        }
    }

    public void addChips() {
        chips++;
    }

    public double calculateTotal() {
        double sandwichTotal = sandwiches.stream().mapToDouble(Sandwich::calculateCost).sum();
        double drinkTotal = smallDrink * 2.0 + mediumDrink + 2.5 + largeDrink *3.0;
        double chipsTotal = chips * 1.5;

        return sandwichTotal + drinkTotal + chipsTotal;
    }

    public void displayOrderSummary() {
        System.out.println("Order Summary:");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }

        System.out.println("Small Drinks: " + smallDrink);
        System.out.println("Medium Drinks: " + mediumDrink);
        System.out.println("Large Drinks: " + largeDrink);
        System.out.println("Chips: " + chips);
        System.out.println("Total Cost: $" + calculateTotal());
    }

}
