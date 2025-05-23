package com.pluralsight;

public abstract class Topping {

    String name;
    Size size;

    public Topping(Size size) {
        this.size = size;
    }

    abstract double getPrice();
}
