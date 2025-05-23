package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Item {

    BreadType bread;
    Size size;
    List<Topping> contents;
    boolean toasted;

    public Sandwich(BreadType bread, Size size, boolean toasted) {
        contents = new ArrayList<>();
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
    }

    public String showSandwich() {
        throw new RuntimeException("not yet implemented");
    }

    public void addTopping(Topping topping) {
        contents.add(topping);
    }

    public void removeTopping(Topping topping) {
        contents.remove(topping);
    }

    @Override
    public double getPrice() {
        double total = size.basePrice;
        for (Topping topping : contents) {
            total += topping.getPrice();
        }
        return total;
    }
}
