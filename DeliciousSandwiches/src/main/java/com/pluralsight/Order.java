package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private int smallDrink;
    private int mediumDrink;
    private int largeDrink;
    private int chips;
    private final List<String> drinks;
    private List<String> chipTypes;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.smallDrink = 0;
        this.mediumDrink = 0;
        this.largeDrink = 0;
        this.chips = 0;
        this.drinks = new ArrayList<>();
        this.chipTypes = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(String size, String choice) {
        switch (size.toLowerCase()) {
            case "small":
                smallDrink++;
                break;
            case "medium":
                mediumDrink++;
                break;
            case "large":
                largeDrink++;
                break;
            default:
                System.out.println("Invalid size. Please select 'small', 'medium', or 'large'.");
                return; // Exit if an invalid size is provided
        }
        drinks.add(size + " " + choice); // Store the size and drink choice
    }


    public void addChips(String choice) {
        chips++;
        chipTypes.add(choice);
    }

    public double calculateTotal() {
        double sandwichTotal = sandwiches.stream().mapToDouble(Sandwich::calculateCost).sum();
        double drinkTotal = smallDrink * 2.0 + mediumDrink * 2.5 + largeDrink *3.0;
        double chipsTotal = chips * 1.5;

        return sandwichTotal + drinkTotal + chipsTotal;
    }

    public void displayOrderSummary() {
        System.out.println("\nOrder Summary:");
        for (Sandwich sandwich : sandwiches) {
            System.out.println(sandwich);
        }

        // Display each drink with its size and choice
        if (!drinks.isEmpty()) {
            System.out.println("Drinks:");
            for (String drink : drinks) {
                System.out.println(" - " + drink);
            }
        } else {
            System.out.println("No drinks selected.");
        }

        // Display each chip choice
        if (!chipTypes.isEmpty()) {
            System.out.println("Chips:");
            for (String chip : chipTypes) {
                System.out.println(" - " + chip);
            }
        } else {
            System.out.println("No chips selected.");
        }

        System.out.println("Total Cost: $" + calculateTotal());
    }

}
