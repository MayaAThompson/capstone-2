package com.pluralsight;

public enum Size {
    SMALL(4, 5.5, 1.0, .5, .75, .3, 2.0),
    MEDIUM(8, 7.0, 2.0, 1.0, 1.5, .60, 2.5),
    LARGE(12, 8.5, 3.0, 1.50, 2.25, .9, 3.0);

    public final int sandwichLength;
    public final double basePrice;
    public final double meatPrice;
    public final double extraMeatPrice;
    public final double cheesePrice;
    public final double extraCheesePrice;
    public final double drinkPrice;

    Size(int sandwichLength, double basePrice, double meatPrice, double extraMeatPrice, double cheesePrice, double extraCheesePrice, double drinkPrice) {
        this.sandwichLength = sandwichLength;
        this.basePrice = basePrice;
        this.meatPrice = meatPrice;
        this.extraMeatPrice = extraMeatPrice;
        this.cheesePrice = cheesePrice;
        this.extraCheesePrice = extraCheesePrice;
        this.drinkPrice = drinkPrice;
    }
}
