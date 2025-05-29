package com.pluralsight.items;

import com.pluralsight.toppings.*;

import java.util.ArrayList;

public class BltSandwich extends Sandwich {

    public BltSandwich(int size) {
        toppings = new ArrayList<>();
        signature = true;
        this.selectSize(size);
        this.bread = BreadType.WHEAT;
        this.toasted = true;
        toppings.add(new Meat(MeatType.BACON, this.size, false));
        toppings.add(new RegularTopping(this.size, RegularToppingType.LETTUCE));
        toppings.add(new RegularTopping(this.size, RegularToppingType.TOMATO));
        toppings.add(new Sauce(this.size, SauceType.MAYO, false));
    }
}
