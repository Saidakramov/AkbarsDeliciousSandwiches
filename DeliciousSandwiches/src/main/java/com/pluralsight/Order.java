package com.pluralsight;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
        switch (size) {
            case "1":
                size = "small";
                smallDrink++;
                break;
            case "2":
                size = "medium";
                mediumDrink++;
                break;
            case "3":
                size = "large";
                largeDrink++;
                break;
            default:
                System.out.println("Invalid size. Please select 1 'for small', 2 'for medium', or 3 'for large drink'.");
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

    public String displayOrderSummary() {
        StringBuilder summary = new StringBuilder();
        summary.append("Order Summary:").append("\n");
        for (Sandwich sandwich : sandwiches) {
            summary.append(sandwich).append("\n");
           summary.append("\n").append(sandwich.displaySandwichCost()).append("\n");
        }

        // Display each drink with its size and choice
        if (!drinks.isEmpty()) {
            summary.append("Drinks:\n");
            for (String drink : drinks) {
                summary.append(" - ").append(drink).append("\n");
            }
        } else {
            summary.append("No drinks selected.\n");
        }

        // Display each chip choice
        if (!chipTypes.isEmpty()) {
            summary.append("\nChips:\n");
            for (String chip : chipTypes) {
                summary.append(" - ").append(chip).append("\n");
            }
        } else {
            summary.append("No chips selected.\n");
        }

        summary.append("\nTotal Cost: $").append(calculateTotal()).append("\n");
        return summary.toString();
    }

    public void receipts() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        String filename = "receipts/" + timestamp + ".txt";

        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("Order Receipt\n");
            writer.write("=========================\n");

            //write order details to the receipt
           writer.write(displayOrderSummary());

            writer.write("========================\n");
            System.out.println("Receipt save as :" + filename);

        } catch (IOException e) {
            System.out.println("Error message code is : " + e.getMessage());
        }
    }

}
