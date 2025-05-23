package com.pluralsight.toppings;

import com.pluralsight.Size;

public class Meat extends Topping{

    MeatType meatType;
    boolean extra;

    public Meat(Size size, MeatType meatType, boolean extra) {
        super(size);
        this.meatType = meatType;
        this.extra = extra;
        this.name = meatType.toString();
    }

    @Override
    public double getPrice() {
        if (extra)
            return size.extraMeatPrice;
        else
            return size.meatPrice;
    }
}
