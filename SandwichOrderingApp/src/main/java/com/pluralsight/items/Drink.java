package com.pluralsight.items;

import com.pluralsight.Size;

public class Drink extends Item{

    DrinkFlavor flavor;
    Size size;

    public Drink() {
    }

    public Drink(DrinkFlavor flavor, Size size) {
        this.flavor = flavor;
        this.size = size;
    }

    @Override
    public double getPrice() {
        return size.drinkPrice;
    }

    @Override
    public String getName() {
        return this.size + " " + this.flavor;
    }

    public void setFlavor(int selection) {
        switch (selection) {
            case 1 -> this.flavor = DrinkFlavor.COLA;
            case 2 -> this.flavor = DrinkFlavor.LEMON_LIME;
            case 3 -> this.flavor = DrinkFlavor.NURSE_PEPPER;
            case 4 -> this.flavor = DrinkFlavor.LEMONADE;
            case 5 -> this.flavor = DrinkFlavor.MOONKIST;
            case 6 -> this.flavor = DrinkFlavor.ROOT_BEER;
            case 7 -> this.flavor = DrinkFlavor.GRAPE;
            case 8 -> this.flavor = DrinkFlavor.SWEET_TEA;
            default -> System.out.println("Please select an available flavor");
        }
    }

    public void setSize(int selection) {
        switch (selection) {
            case 1 -> this.size = Size.SMALL;
            case 2 -> this.size = Size.MEDIUM;
            case 3 -> this.size = Size.LARGE;
            default -> System.out.println("Please select an available size");
        }
    }

    public DrinkFlavor getFlavor() {
        return flavor;
    }

    public Size getSize() {
        return size;
    }
}
