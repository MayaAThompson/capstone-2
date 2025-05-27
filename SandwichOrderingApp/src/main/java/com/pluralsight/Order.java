package com.pluralsight;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Item;
import com.pluralsight.items.Sandwich;

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
        this.items.add(sandwich);
    }

    public void addChip(Chip chip) {
        this.items.add(chip);
    }

    public void addDrink(Drink drink) {
        this.items.add(drink);
    }

    public void removeItem(Item item) {
        this.items.remove(item);
    }

    public List<Item> getOrder() {
        return items;
    }
}
