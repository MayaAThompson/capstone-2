package com.pluralsight.toppings;

import com.pluralsight.Size;

public class Sauce extends Topping{

    boolean onTheSide;
    SauceType sauceType;

    public Sauce(Size size, SauceType sauceType, boolean onTheSide) {
        super(size);
        this.sauceType = sauceType;
        this.onTheSide = onTheSide;
        this.name = sauceType.toString();
    }

    @Override
    public double getPrice() {
        return 0;
    }
}
