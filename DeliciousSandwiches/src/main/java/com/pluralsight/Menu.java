package com.pluralsight;

public class Menu {
    public static final String[] BREAD_TYPES = {"White", "Wheat", "Rye", "Wrap"};
    public static final String[] SIZES = {"4\"", "8\"", "12\""};

    public static final Toppings[] PREMIUM_MEATS = {
            new Toppings("Steak", true, 1.0, 2.0, 3.0),
            new Toppings("Ham", true, 1.0, 2.0, 3.0),
            new Toppings("Salami", true, 1.0, 2.0, 3.0),
            new Toppings("Roast Beef", true, 1.0, 2.0, 3.0),
            new Toppings("Chicken", true, 1.0, 2.0, 3.0),
            new Toppings("Bacon", true, 1.0, 2.0, 3.0)
    };

    public static final Toppings[] PREMIUM_CHEESES = {
            new Toppings("American", true, 0.75, 1.5, 2.25),
            new Toppings("Provolone", true, 0.75, 1.5, 2.25),
            new Toppings("Cheddar", true, 0.75, 1.5, 2.25),
            new Toppings("Swiss", true, 0.75, 1.5, 2.25)
    };

    public static final Toppings[] REGULAR_TOPPINGS = {
            new Toppings("Lettuce", false, 0, 0, 0),
            new Toppings("Peppers", false, 0, 0, 0),
            new Toppings("Onions", false, 0, 0, 0),
            new Toppings("Tomatoes", false, 0, 0, 0),
            new Toppings("Jalapenos", false, 0, 0, 0),
            new Toppings("Cucumbers", false, 0, 0, 0),
            new Toppings("Pickles", false, 0, 0, 0),
            new Toppings("Guacamole", false, 0, 0, 0),
            new Toppings("Mushrooms", false, 0, 0, 0)
    };


}
