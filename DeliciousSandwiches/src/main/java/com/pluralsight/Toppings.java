package com.pluralsight;


public class Toppings {
    private String name;
    private boolean isPremium;
    private double price4Inch;
    private double price8Inch;
    private double price12Inch;

    public Toppings(String name, boolean isPremium, double price4Inch, double price8Inch, double price12Inch) {
        this.name = name;
        this.isPremium = isPremium;
        this.price4Inch = price4Inch;
        this.price8Inch = price8Inch;
        this.price12Inch = price12Inch;
    }

    // Returns the price of this topping based on sandwich size
    public double getPrice(int size) {
        return switch (size) {
            case 4 -> price4Inch;
            case 8 -> price8Inch;
            case 12 -> price12Inch;
            default -> 0;
        };
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    @Override
    public String toString() {
        return "Toppings{" +
                "name='" + name + '\'' +
                ", isPremium=" + isPremium +
                ", price4Inch=" + price4Inch +
                ", price8Inch=" + price8Inch +
                ", price12Inch=" + price12Inch +
                '}';
    }
}