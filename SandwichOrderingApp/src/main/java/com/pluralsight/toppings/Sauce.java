package com.pluralsight.toppings;

import com.pluralsight.Size;

@SuppressWarnings("FieldMayBeFinal")
public class Sauce extends Topping {

    private boolean onTheSide;
    private SauceType sauceType;

    public Sauce(Size size, SauceType sauceType, boolean onTheSide) {
        super(size);
        this.sauceType = sauceType;
        this.onTheSide = onTheSide;
        this.name = sauceType.toString();
    }

    public boolean isOnTheSide() {
        return onTheSide;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return this.sauceType.toString();
    }
}
