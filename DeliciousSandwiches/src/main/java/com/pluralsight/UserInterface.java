package com.pluralsight;

import java.util.Scanner;
import static com.pluralsight.SandwichBuilder.*;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);
    private static Order currentOrder;

    public static void main(String[] args) {
        System.out.println("Welcome to Akbar's Delicious Sandwiches!");
        homeScreen();

    }

    public static void homeScreen() {
        String opt = input("\nPlease choose options below:" +
                "\n(1) - New Order" +
                "\n(0) - Exit - exit the application" +
                "\n ");


        switch (opt) {
            case "1" :
                currentOrder = new Order();
                orderScreen();
                break;
            case "0" :
                System.out.println("Thank you! Have a great day!");
                System.exit(0);
            default:
                System.out.println("Invalid input. Please enter 1 or 2.");
                homeScreen();
        }
    }

    public static void orderScreen() {
        String opt = input("\nPlease choose options below: " +
                "\n(1) - Add Sandwich " +
                "\n(2) - Add Drink " +
                "\n(3) - Add Chips " +
                "\n(4) - Checkout " +
                "\n(0) - Cancel Order " +
                "\n ");

        switch (opt) {
            case "1":
                SandwichBuilder.buildSandwichLoop(currentOrder);
                orderScreen();
                break;
            case "2":
                SandwichBuilder.addDrink(currentOrder);
                orderScreen();
                break;
            case "3":
                SandwichBuilder.addChips(currentOrder);
                orderScreen();
            case "4":
                checkout();
                break;
            case "0":
                System.out.println("Order canceled.");
                currentOrder = null; // reset current order
                homeScreen();
                break;
            default:
                System.out.println("Invalid option. Please try again.");
                orderScreen();

        }
    }

    public static void checkout() {
        if (currentOrder != null) {
            System.out.println(currentOrder.displayOrderSummary());
        }
        String opt = input("Would like to proceed with the order?" +
                "\n(1) - Confirm" +
                "\n(2) - Cancel" +
                "\n ");

        switch (opt) {
            case "1":
                currentOrder.receipts();
                System.out.println("Thank you for your order!");
                homeScreen();
                break;
            case "2":
                System.out.println("Order canceled.");
                currentOrder = null;
                homeScreen();
                break;
            default:
                System.out.println("Invalid input. Please enter 1 or 2");
                checkout();
        }
    }

}
