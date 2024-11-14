package com.pluralsight;


import java.util.Scanner;
import static com.pluralsight.SandwichBuilder.*;

public class UserInterface {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Akbar's Delicious Sandwiches!");
        homeScreen();

    }

    public static void homeScreen() {
        String opt = input("\nPlease choose options below:" +
                "\n(1) - New order" +
                "\n(0) - Exit - exit the application" +
                "\n ");


        switch (opt) {
            case "1" : orderScreen(); break;
            case "0" : System.exit(0);
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
                buildSandwichLoop();
                orderScreen();
                break;
            case "2":
                addDrink();
                orderScreen();
                break;
            case "3":
                addChips();
                orderScreen();
            case "4":
                Order order = new Order();
                order.displayOrderSummary();
                break;
            case "0":
                homeScreen();

        }
    }

}
