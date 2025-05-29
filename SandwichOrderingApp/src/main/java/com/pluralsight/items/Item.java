package com.pluralsight.items;

public abstract class Item {

    abstract double getPrice();

    public abstract String getName();

    @Override
    public String toString() {
        return this.getName() + " " + this.getPrice();
    }
}
