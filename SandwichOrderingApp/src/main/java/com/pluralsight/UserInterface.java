package com.pluralsight;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Item;
import com.pluralsight.items.Sandwich;
import com.pluralsight.utils.IOUtils;

import java.util.List;

public class UserInterface {

    public void displayHomeScreen() {
        System.out.println("""
                -----Home-----
                
                1) New order
                0) Exit
                """);
    }

    public void displayOrderScreen() {
        System.out.println("""
                -----Order-----
                
                1) Add custom sandwich
                2) Add signature sandwich
                3) Add drink
                4) Add chips
                5) Checkout
                0) Cancel Order""");
    }

    public void displaySandwichScreen() {

    }

    public void displaySizeScreen() {
        System.out.println("""
                -----Size-----
                
                1) Small
                2) Medium
                3) Large
                0) Cancel""");
    }

    public void displayChipScreen() {
        System.out.println("""
                -----Chip Flavors-----
                
                1) Plain
                2) BBQ
                3) Cracked Pepper
                4) Jalapeno
                5) Chill Ranch
                6) Cheesy
                0) Cancel""");
    }

    public void displayDrinkFlavorScreen() {
        System.out.println("""
                -----Drinks-----
                
                1) Cola
                2) Lemon-Lime
                3) Nurse Pepper
                4) Lemonade
                5) Moonkist
                6) Root Beer
                7) Grape Soda
                0) Cancel""");
    }

    public void displayCheckoutScreen(List<Item> items) {
        System.out.println("-----Checkout-----");
        displayOrder(items);
        System.out.println("1) Confirm\n0) Cancel");
    }

    public void displayOrder(List<Item> items) {
        System.out.println("-----Your Order-----\n");
        double total = 0;
        for (Item item : items) {
            System.out.println(item);
            if (item instanceof Sandwich)
                total += ((Sandwich) item).getPrice();
            else if (item instanceof Chip)
                total += ((Chip) item).getPrice();
            else if (item instanceof Drink)
                total += ((Drink) item).getPrice();
            else
                total = 0;
        }
        System.out.printf("Total: $%.2f", total);
    }

    public int screenSelection() {
        try {
            return IOUtils.messageAndResponseInt("Make your selection: ");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
