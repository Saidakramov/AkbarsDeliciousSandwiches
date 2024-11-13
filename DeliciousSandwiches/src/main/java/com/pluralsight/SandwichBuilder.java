package com.pluralsight;

import java.util.Scanner;

public class SandwichBuilder {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Optional order = new Optional();
        System.out.println("Welcome to Akbar's Delicious Sandwiches!");

        String addMoreSandwiches;

        // Allow the user to build multiple sandwiches in the same order
        do {
            Sandwich sandwich = buildSandwich();
            order.addSandwich(sandwich);

            addMoreSandwiches = input("\nWould you like to add another sandwich to your order? (y/n): ").toLowerCase();
        } while (addMoreSandwiches.equals("y"));

        // Optionally add drinks and chips to the order
        addExtras(order);

        // Display the complete order summary
        order.displayOrderSummary();
    }

    public static Sandwich buildSandwich() {
        System.out.println("\nLet's build your sandwich.");

        int size = Integer.parseInt(input("Choose your sandwich size (4, 8, or 12 inches): ").trim());
        String breadType = input("Choose your bread type (White, Wheat, Rye, Wrap): ");
        boolean toasted = input("Would you like it toasted? (y/n): ").equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(breadType, size, toasted);

        // Add regular toppings
        System.out.println("Select regular toppings (type names separated by commas, or type 'all' for everything, or 'none' to skip):");
        printToppings(Menu.REGULAR_TOPPINGS);
        String regularChoice = scanner.nextLine();
        addTopping(sandwich, regularChoice, Menu.REGULAR_TOPPINGS);

        // Add premium meats
        System.out.println("Select premium meats (type names separated by commas, or 'none' to skip):");
        printToppings(Menu.PREMIUM_MEATS);
        String meatChoice = scanner.nextLine();
        addTopping(sandwich, meatChoice, Menu.PREMIUM_MEATS);

        // Add premium cheeses
        System.out.println("Select premium cheeses (type names separated by commas, or 'none' to skip):");
        printToppings(Menu.PREMIUM_CHEESES);
        String cheeseChoice = scanner.nextLine();
        addTopping(sandwich, cheeseChoice, Menu.PREMIUM_CHEESES);

        // Prompt for extra meat and cheese
        String extraMeat = input("Would you like extra meat? (y/n): ");
        if (extraMeat.equalsIgnoreCase("y")) {
            sandwich.addExtraMeat();
        }

        String extraCheese = input("Would you like extra cheese? (y/n): ");
        if (extraCheese.equalsIgnoreCase("y")) {
            sandwich.addExtraCheese();
        }

        return sandwich;
    }

    public static void addTopping(Sandwich sandwich, String choice, Toppings[] toppings) {
        if (choice.equalsIgnoreCase("none")) {
            return;
        }

        // If the choice is "all", add all toppings to the sandwich
        if (choice.equalsIgnoreCase("all")) {
            for (Toppings t : toppings) {
                sandwich.addTopping(t);
            }
            return; // No need to process further if "all" is selected
        }

        // Otherwise, process individual toppings
        String[] selectedToppings = choice.split(",");
        for (String toppingName : selectedToppings) {
            toppingName = toppingName.trim(); // Trim the topping name to avoid issues with spaces

            // Find the topping and add it to the sandwich if it exists
            for (Toppings t : toppings) {
                if (t.getName().equalsIgnoreCase(toppingName)) {
                    sandwich.addTopping(t);
                    break; // Once we find the topping, no need to check further
                }
            }
        }
    }

    public static void addExtras(Optional order) {
        // Add drinks
        String drinkSize;
        do {
            drinkSize = input("Would you like to add a drink? (small/medium/large or 'none' to skip): ").toLowerCase();
            if (!drinkSize.equals("none")) {
                order.addDrink(drinkSize);
            }
        } while (!drinkSize.equals("none"));

        // Add chips
        String addChips = input("Would you like to add chips? (y/n): ").toLowerCase();
        if (addChips.equals("y")) {
            order.addChips();
        }
    }

    public static void printToppings(Toppings[] toppings) {
        for (Toppings t : toppings) {
            System.out.print(t.getName() + " ");
        }
        System.out.println();
    }

    public static String input(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}