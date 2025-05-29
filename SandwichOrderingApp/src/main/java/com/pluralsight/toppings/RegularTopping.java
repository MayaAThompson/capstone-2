package com.pluralsight.toppings;

import com.pluralsight.Size;

@SuppressWarnings("FieldMayBeFinal")
public class RegularTopping extends Topping{

    private RegularToppingType regularToppingType;

    public RegularTopping(Size size, RegularToppingType regularToppingType) {
        super(size);
        this.regularToppingType = regularToppingType;
        this.name = regularToppingType.toString();
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return this.regularToppingType.toString();
    }
}
