package com.pluralsight;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Item;
import com.pluralsight.items.Sandwich;

import java.util.ArrayList;
import java.util.List;

public class Order {

    @SuppressWarnings("FieldMayBeFinal")
    private String name;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Item> items;
    public Order(String name) {
        items = new ArrayList<>();
        this.name = name;
    }

    public String getName() {
        return name;
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

    public void removeItem(int i) {
        System.out.println(this.items.get(i - 1).getName() + " Removed");
        this.items.remove(i - 1);
    }

    public List<Item> getOrder() {
        return items;
    }
}
