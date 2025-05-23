package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Order {

    String name;
    List<Item> items;

    public Order(String name) {
        items = new ArrayList<>();
        this.name = name;
    }

    public void addSandwich(Sandwich sandwich) {

    }

    public void addChip(Chip chip) {

    }

    public void addDrink(Drink drink) {

    }

    public void removeItem(Item item) {

    }

    public List<Item> getOrder() {
        return items;
    }
}
