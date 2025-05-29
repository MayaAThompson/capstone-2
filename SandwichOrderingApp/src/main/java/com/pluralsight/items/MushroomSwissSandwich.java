package com.pluralsight.items;

import com.pluralsight.toppings.*;

import java.util.ArrayList;

public class MushroomSwissSandwich extends Sandwich{

    public MushroomSwissSandwich(int size) {
        toppings = new ArrayList<>();
        this.selectSize(size);
        this.bread = BreadType.WHITE;
        this.toasted = true;
        toppings.add(new Meat(MeatType.HAM, this.size, false));
        toppings.add(new Cheese(CheeseType.SWISS, this.size, false));
        toppings.add(new RegularTopping(this.size, RegularToppingType.MUSHROOM));
    }
}
