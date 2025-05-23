package com.pluralsight;

public class RegularTopping extends Topping{

    RegularToppingType regularToppingType;

    public RegularTopping(Size size, RegularToppingType regularToppingType) {
        super(size);
        this.regularToppingType = regularToppingType;
        this.name = regularToppingType.toString();
    }

    @Override
    double getPrice() {
        return 0;
    }
}
