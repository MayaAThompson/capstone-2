package com.pluralsight.toppings;

import com.pluralsight.Size;

public abstract class Topping {

    String name;
    Size size;

    public Topping(Size size) {
        this.size = size;
    }

    abstract public double getPrice();
}
