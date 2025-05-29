package com.pluralsight.items;

public abstract class Item {

    abstract public double getPrice();

    abstract public String getName();

    @Override
    public String toString() {
        return String.format("%.2f\n%s ", this.getPrice(), this.getName());
    }
}
