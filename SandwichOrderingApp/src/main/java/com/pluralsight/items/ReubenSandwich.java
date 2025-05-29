package com.pluralsight.items;

import com.pluralsight.UserInterface;
import com.pluralsight.toppings.*;

import java.util.ArrayList;

public class ReubenSandwich extends Sandwich{

    public ReubenSandwich(int size) {
        this.selectSize(size);
        toppings = new ArrayList<>();
        signature = true;
        this.bread = BreadType.RYE;
        this.toasted = true;
        toppings.add(new Meat(MeatType.ROAST_BEEF, this.size, false));
        toppings.add(new Cheese(CheeseType.SWISS, this.size, false));
        toppings.add(new Sauce(this.size, SauceType.THOUSAND_ISLAND, false));
    }
}
