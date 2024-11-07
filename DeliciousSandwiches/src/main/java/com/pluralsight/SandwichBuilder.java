package com.pluralsight;

import java.util.Scanner;

public class SandwichBuilder {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Order order = new Order();
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

        String size = input("Choose your sandwich size (4, 8, or 12 inches): ");
        String breadType = input("Choose your bread type (White, Wheat, Rye, Wrap): ");
        boolean toasted = input("Would you like it toasted? (y/n): ").equalsIgnoreCase("y");

        Sandwich sandwich = new Sandwich(size, breadType, toasted);

        // Add regular toppings
        System.out.println("Select regular toppings (type names separated by commas, or 'none' to skip):");
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
        if (!choice.equalsIgnoreCase("none")) {
            String[] selectedToppings = choice.split(",");
            for (String toppingName : selectedToppings) {
                toppingName = toppingName.trim();
                for (Toppings t : toppings) {
                    if (t.getName().equalsIgnoreCase(toppingName)) {
                        sandwich.addTopping(t);
                    }
                }
            }
        }
    }

    public static void addExtras(Order order) {
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