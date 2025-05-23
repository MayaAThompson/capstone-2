package com.pluralsight;

public abstract class Item {

    String name;

    abstract double getPrice();

    public String getName() {
        return this.name;
    }
}
