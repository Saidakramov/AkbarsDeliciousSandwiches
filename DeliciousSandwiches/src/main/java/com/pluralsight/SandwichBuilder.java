package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class SandwichBuilder {
    private static final Scanner scanner = new Scanner(System.in);

    public static void buildSandwichLoop(Order order) {
        String addMoreSandwiches;

        // Allow the user to build multiple sandwiches in the same order
        do {
            Sandwich sandwich = buildSandwich();
            order.addSandwich(sandwich);

            addMoreSandwiches = input("\nWould you like to add another sandwich to your order? (y/n): ").toLowerCase();
        } while (addMoreSandwiches.equals("y"));

    }

    public static Sandwich buildSandwich() {
        System.out.println("\nLet's build your sandwich.");

        //bread type options
        String breadType = input("Choose your bread type (White, Wheat, Rye, Wrap): ");

        //bread size options
        int size = Integer.parseInt(input("Choose your sandwich size (4, 8, or 12 inches): ").trim());
        Sandwich sandwich = new Sandwich(breadType, size);

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

        // Add regular toppings
        System.out.println("Select regular toppings (type names separated by commas, or type 'all' for everything, or 'none' to skip):");
        printToppings(Menu.REGULAR_TOPPINGS);
        String regularChoice = scanner.nextLine();
        addTopping(sandwich, regularChoice, Menu.REGULAR_TOPPINGS);

        //sauces options
        System.out.println("Select your favourite sauces (type names separated by commas, or type 'all' for everything, or 'none' to skip):");
        printSauces(Menu.SAUCES);
        String sauceChoice = scanner.nextLine();
        addSauces(sandwich, sauceChoice, Menu.SAUCES);

        //side options
        System.out.println("Select your favourite side or 'none' to skip):");
        printSides(Menu.SIDES);
        String sideChoice = scanner.nextLine();
        addSide(sandwich, sideChoice, Menu.SIDES);

        boolean toasted = input("Would you like it toasted? (y/n): ").equalsIgnoreCase("y");
        sandwich.setToasted(true);

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

    public static void addDrink(Order order) {
        String drinkSize;
        // Loop until a valid size or "none" is entered
        while (true) {
            drinkSize = input("Would you like to add a drink? " +
                    "\n(1) - small $2.00 " +
                    "\n(2) - medium $2.50" +
                    "\n(3) - large  $3.50 " +
                    "\n(0) - no drinks " +
                    "\n ");

            if (drinkSize.equals("0")) {
                return; // Skip if "none" is selected
            } else if (drinkSize.equals("1") || drinkSize.equals("2") || drinkSize.equals("3")) {
                break; // Exit the loop if a valid size is entered
            } else {
                System.out.println("Invalid size. Please select 1, 2, 3 or 0.");
            }
        }
        System.out.println("Select your favourite drink :");
        printDrinks(Menu.DRINKS);
        String drinkChoice = scanner.nextLine().trim();
        order.addDrink(drinkSize, drinkChoice);
    }

    public static void addChips(Order order) {
        String addChips;
        // Loop to ensure valid input (y or n)
        while (true) {
            addChips = input("Would you like to add chips? (y/n): ").toLowerCase();

            if (addChips.equals("n")) {
                return; // Exit if the user doesn't want chips
            } else if (addChips.equals("y")) {
                break; // Proceed if the user wants chips
            } else {
                System.out.println("Invalid input. Please enter 'y' for yes or 'n' for no.");
            }
        }

        // If the user wants chips, prompt for chip choice
        System.out.println("Select your favorite chips:");
        printChips(Menu.CHIPS);
        String chipsChoice = scanner.nextLine().trim();
        order.addChips(chipsChoice); // Adds the selected chip choice to the order
    }

    public static void addSauces(Sandwich sandwich, String choice, List<String> sauces) {
        //System.out.println("User selected sauces: " + choice); // Debugging line

        if (choice.equalsIgnoreCase("none")) {
            return;
        }

        if (choice.equalsIgnoreCase("all")) {
            for (String sauce : sauces) {
                //System.out.println("Adding sauce: " + sauce); // Debugging line
                sandwich.addSauce(sauce);
            }
            return;
        }

        String[] selectedSauces = choice.split(",");
        for (String sauceName : selectedSauces) {
            sauceName = sauceName.trim().toLowerCase(); // Normalize user input to lowercase
            for (String sauce : sauces) {
                if (sauce.toLowerCase().equals(sauceName)) { // Case-insensitive comparison
                    sandwich.addSauce(sauce); // Add original case sauce from list
                    break; // Exit loop after match is found
                }
            }
        }
    }

    public static void addSide(Sandwich sandwich, String choice, List<String> sides) {
        if (choice.equalsIgnoreCase("none")) {
            return;
        }

        for (String side : sides) {
            if (choice.equalsIgnoreCase(side)) {
                sandwich.addSide(side);
                return;
            }
        }
        System.out.println("Invalid input. Please enter the correct type.");
    }


    public static void printToppings(Toppings[] toppings) {
        for (Toppings t : toppings) {
            System.out.print(t.getName() + " ");
        }
        System.out.println();
    }

    public static void printSauces(List<String> sauces) {
        for (String s : sauces) {
            System.out.print(s + " ");
        }
        System.out.println();
    }

    public static void printSides(List<String> sides) {
        for (String side : sides) {
            System.out.println(side + " ");
        }
        System.out.println();
    }

    public static void printDrinks(List<String> drinks) {
        for (String d : drinks) {
            System.out.print(d + " ");
        }
        System.out.println();
    }

    public static void printChips(List<String> chips) {
        for (String ch : chips) {
            System.out.print(ch + " ");
        }
        System.out.println();
    }

    public static String input(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}