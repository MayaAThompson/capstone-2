package com.pluralsight.items;

import com.pluralsight.UserInterface;
import com.pluralsight.toppings.*;

import java.util.ArrayList;

public class CubanSandwich extends Sandwich{

    public CubanSandwich(int size) {
        this.selectSize(size);
        toppings = new ArrayList<>();
        this.bread = BreadType.WHITE;
        this.toasted = true;
        toppings.add(new Meat(MeatType.HAM, this.size, false));
        toppings.add(new Meat(MeatType.SALAMI, this.size, true));
        toppings.add(new Cheese(CheeseType.SWISS, this.size, false));
        toppings.add(new RegularTopping(this.size, RegularToppingType.PICKLE));
        toppings.add(new Sauce(this.size, SauceType.MUSTARD, false));
    }
}
