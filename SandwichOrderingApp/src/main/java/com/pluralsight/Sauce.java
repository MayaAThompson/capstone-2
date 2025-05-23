package com.pluralsight;

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
    double getPrice() {
        return 0;
    }
}
