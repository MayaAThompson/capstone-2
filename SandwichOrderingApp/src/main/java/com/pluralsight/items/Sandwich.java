package com.pluralsight.items;

import com.pluralsight.Size;
import com.pluralsight.toppings.BreadType;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.CheeseType;
import com.pluralsight.toppings.Topping;
import com.pluralsight.utils.IOUtils;

import java.util.ArrayList;
import java.util.List;

public class Sandwich extends Item {

    BreadType bread;
    Size size;
    List<Topping> toppings;
    boolean toasted;

    public Sandwich(BreadType bread, Size size, boolean toasted) {
        toppings = new ArrayList<>();
        this.bread = bread;
        this.size = size;
        this.toasted = toasted;
    }

    public Sandwich() {
        toppings = new ArrayList<>();
    }

    public String showSandwich() {
        throw new RuntimeException("not yet implemented");
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    @Override
    public double getPrice() {
        double total = size.basePrice;
        for (Topping topping : toppings) {
            total += topping.getPrice();
        }
        return total;
    }

    public void selectBread() {
        System.out.println("-----Bread Types-----");
        System.out.println("""
                1) White
                2) Wheat
                3) Rye
                4) Wrap""");
        int selection = IOUtils.messageAndResponseInt("Select your bread");
        switch (selection) {
            case 1 -> this.bread = BreadType.WHITE;
            case 2 -> this.bread = BreadType.WHEAT;
            case 3 -> this.bread = BreadType.RYE;
            case 4 -> this.bread = BreadType.WRAP;
            default -> System.out.println("Please select an available bread type.");
        }
    }

    public void selectSize() {
        System.out.println("-----Sizes-----");
        System.out.println("""
                1) Small
                2) Medium
                3) large""");
        int selection = IOUtils.messageAndResponseInt("Select your size: ");
        switch (selection) {
            case 1 -> this.size = Size.SMALL;
            case 2 -> this.size = Size.MEDIUM;
            case 3 -> this.size = Size.LARGE;
            default -> System.out.println("Please select and available bread type");
        }
    }

    public void selectToasted() {
        char selection;
        do {
            selection = IOUtils.messageAndResponse("Would you like it toasted? (Y/N)").toUpperCase().charAt(0);
            if (selection == 'Y')
                this.toasted = true;
            else if (selection == 'N')
                this.toasted = false;
            else
                System.out.println("Please select Yes or No");
        } while (selection != 'Y' && selection != 'N');
    }


    public int cheeseSelection() {
        return IOUtils.messageAndResponseInt("""
                -----Cheese-----
                1) American
                2) Provolone
                3) Cheddar
                4) Swiss""");
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
}
