package com.pluralsight;

public enum Size {
    SMALL(4, 5.5, 1.0, .5, .75, .3, 2.0),
    MEDIUM(8, 7.0, 2.0, 1.0, 1.5, .60, 2.5),
    LARGE(12, 8.5, 3.0, 1.50, 2.25, .9, 3.0);

    final int sandwichLength;
    final double basePrice;
    final double meatPrice;
    final double extraMeatPrice;
    final double cheesePrice;
    final double extraCheesePrice;
    final double drinkPrice;

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
