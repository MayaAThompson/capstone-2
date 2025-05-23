package com.pluralsight.toppings;

import com.pluralsight.Size;

public class Cheese extends Topping{

    private CheeseType cheeseType;
    private boolean extra;

    public Cheese(CheeseType cheeseType, Size size, boolean extra) {
        super(size);
        this.cheeseType = cheeseType;
        this.extra = extra;
        this.name = cheeseType.toString();
    }

    @Override
    public double getPrice() {
        if (extra)
            return size.extraCheesePrice;
        else
            return size.cheesePrice;
    }
}
