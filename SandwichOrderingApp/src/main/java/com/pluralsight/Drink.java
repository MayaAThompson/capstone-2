package com.pluralsight;

public class Drink extends Item{

    DrinkFlavor flavor;
    Size size;

    public Drink(DrinkFlavor flavor, Size size) {
        this.flavor = flavor;
        this.size = size;
        this.name = flavor.toString();
    }

    @Override
    public double getPrice() {
        return size.drinkPrice;
    }
}
