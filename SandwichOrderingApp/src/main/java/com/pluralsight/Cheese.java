package com.pluralsight;

public class Cheese extends Topping{

    CheeseType cheeseType;
    boolean extra;

    public Cheese(CheeseType cheeseType, Size size, boolean extra) {
        super(size);
        this.cheeseType = cheeseType;
        this.extra = extra;
        this.name = cheeseType.toString();
    }

    @Override
    double getPrice() {
        if (extra)
            return size.extraCheesePrice;
        else
            return size.cheesePrice;
    }
}
