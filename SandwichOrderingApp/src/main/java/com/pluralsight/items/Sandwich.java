package com.pluralsight.items;

import com.pluralsight.Size;
import com.pluralsight.toppings.*;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Item {

    protected BreadType bread;
    protected Size size;
    protected List<Topping> toppings;
    protected boolean signature;
    boolean toasted;

    public Sandwich() {
        toppings = new ArrayList<>();
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public String showSandwich() {
        StringBuilder sandwich = new StringBuilder();
        sandwich.append(this.size).append("\n");
        if (toasted)
            sandwich.append("TOASTED ");
        sandwich.append(this.bread);
        for (Topping topping : toppings) {
            sandwich.append("\n").append(topping);
            if (topping instanceof Sauce) {
                if (((Sauce) topping).isOnTheSide())
                    sandwich.append("(on the side)");
            }
        }
        return sandwich.toString();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(int i) {
        System.out.println(toppings.get(i - 1).toString() + " removed.");
        toppings.remove(i - 1);
    }

    @Override
    public double getPrice() {
        double total = size.basePrice;
        for (Topping topping : toppings) {
            total += topping.getPrice();
        }
        return total;
    }

    @Override
    public String getName() {
        return showSandwich();
    }

    public void addBread(int selection) {
        switch (selection) {
            case 1 -> this.bread = BreadType.WHITE;
            case 2 -> this.bread = BreadType.WHEAT;
            case 3 -> this.bread = BreadType.RYE;
            case 4 -> this.bread = BreadType.WRAP;
            default -> System.out.println("Please select an available bread type.");
        }
    }

    public void selectSize(int selection) {
        switch (selection) {
            case 1 -> this.size = Size.SMALL;
            case 2 -> this.size = Size.MEDIUM;
            case 3 -> this.size = Size.LARGE;
            default -> System.out.println("Please select an available size");
        }
    }

    public void selectToasted(boolean selection) {
        this.toasted = selection;
    }

    public void addCheese(int selection) {
        boolean extra = toppings.stream().anyMatch(t -> t.getClass().equals(Cheese.class));

        switch (selection) {
            case 1 -> this.addTopping(new Cheese(CheeseType.AMERICAN, this.size, extra));
            case 2 -> this.addTopping(new Cheese(CheeseType.PROVOLONE, this.size, extra));
            case 3 -> this.addTopping(new Cheese(CheeseType.CHEDDAR, this.size, extra));
            case 4 -> this.addTopping(new Cheese(CheeseType.SWISS, this.size, extra));
            default -> System.out.println("Please select an available cheese.");
        }
    }

    public void addMeat(int selection) {
        boolean extra = toppings.stream().anyMatch(t -> t.getClass().equals(Meat.class));

        switch (selection) {
            case 1 -> this.addTopping(new Meat(MeatType.STEAK, this.size, extra));
            case 2 -> this.addTopping(new Meat(MeatType.HAM, this.size, extra));
            case 3 -> this.addTopping(new Meat(MeatType.SALAMI, this.size, extra));
            case 4 -> this.addTopping(new Meat(MeatType.ROAST_BEEF, this.size, extra));
            case 5 -> this.addTopping(new Meat(MeatType.CHICKEN, this.size, extra));
            case 6 -> this.addTopping(new Meat(MeatType.BACON, this.size, extra));
            default -> System.out.println("Please select an available meat.");
        }
    }

    public void addRegularTopping(int selection) {
        switch (selection) {
            case 1 -> this.addTopping(new RegularTopping(this.size, RegularToppingType.LETTUCE));
            case 2 -> this.addTopping(new RegularTopping(this.size, RegularToppingType.PEPPERS));
            case 3 -> this.addTopping(new RegularTopping(this.size, RegularToppingType.ONION));
            case 4 -> this.addTopping(new RegularTopping(this.size, RegularToppingType.TOMATO));
            case 5 -> this.addTopping(new RegularTopping(this.size, RegularToppingType.JALAPENO));
            case 6 -> this.addTopping(new RegularTopping(this.size, RegularToppingType.CUCUMBER));
            case 7 -> this.addTopping(new RegularTopping(this.size, RegularToppingType.PICKLE));
            case 8 -> this.addTopping(new RegularTopping(this.size, RegularToppingType.GUACAMOLE));
            case 9 -> this.addTopping(new RegularTopping(this.size, RegularToppingType.MUSHROOM));
        }
    }

    public void addSauce(int selection, boolean side) {
        switch (selection) {
            case 1 -> this.addTopping(new Sauce(this.size, SauceType.MAYO, side));
            case 2 -> this.addTopping(new Sauce(this.size, SauceType.MUSTARD, side));
            case 3 -> this.addTopping(new Sauce(this.size, SauceType.KETCHUP, side));
            case 4 -> this.addTopping(new Sauce(this.size, SauceType.RANCH, side));
            case 5 -> this.addTopping(new Sauce(this.size, SauceType.THOUSAND_ISLAND, side));
            case 6 -> this.addTopping(new Sauce(this.size, SauceType.VINAIGRETTE, side));
            case 7 -> this.addTopping(new Sauce(this.size, SauceType.AU_JUS, true));
        }
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isSignature() {
        return signature;
    }
}
