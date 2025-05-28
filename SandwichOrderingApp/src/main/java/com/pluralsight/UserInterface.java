package com.pluralsight;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Item;
import com.pluralsight.items.Sandwich;
import com.pluralsight.toppings.Topping;
import com.pluralsight.utils.IOUtils;
import java.util.List;

public class UserInterface {

    public int homeScreenSelection() {
        System.out.println("""
                -----Home-----
                
                1) New order
                0) Exit""");
        return getSelection();
    }

    public int orderScreenSelection() {
        System.out.println("""
                -----Order-----
                
                1) Add custom sandwich
                2) Add signature sandwich
                3) Add drink
                4) Add chips
                5) Display order
                6) Remove an item
                9) Checkout
                0) Cancel Order""");
        return getSelection();
    }

    public int sandwichScreenSelection() {
        System.out.println("""
                -----Build Your Sandwich-----
                
                1) Meat
                2) Cheese
                3) Toppings
                4) Sauce
                9) Confirm
                0) Cancel""");
        return getSelection();
    }

    public int sizeSelection() {
        System.out.println("""
                -----Sizes-----
                
                1) Small
                2) Medium
                3) large""");
        return getSelection();
    }

    public int breadSelection() {
        System.out.println("""
                -----Bread-----
                
                1) White
                2) Wheat
                3) Rye
                4) Wrap""");
        return getSelection();
    }

    public int meatSelection() {
        System.out.println("""
                -----Meat-----
                
                1) Steak
                2) Ham
                3) Salami
                4) Roast Beef
                5) Chicken
                6) Bacon""");
        return getSelection();
    }

    public int cheeseSelection() {
        System.out.println("""
                -----Cheese-----
                
                1) American
                2) Provolone
                3) Cheddar
                4) Swiss""");
        return getSelection();
    }

    public int regularToppingSelection() {
        System.out.println("""
                -----Toppings-----
                
                1) Lettuce
                2) Peppers
                3) Onion
                4) Tomato
                5) Jalapeno
                6) Cucumber
                7) Pickle
                8) Guacamole
                9) Mushroom""");
        return getSelection();
    }

    public int sauceSelection() {
        System.out.println("""
                -----Sauce-----
                
                1) Mayo
                2) Mustard
                3) Ketchup
                4) Ranch
                5) Thousand Island
                6) Vinaigrette
                7) Au Jus""");
        return getSelection();
    }

    public int chipSelection() {
        System.out.println("""
                -----Chip Flavors-----
                
                1) Plain
                2) BBQ
                3) Cracked Pepper
                4) Jalapeno
                5) Chill Ranch
                6) Cheesy
                0) Cancel""");
        return getSelection();
    }

    public int drinkSelection() {
        System.out.println("""
                -----Drinks-----
                
                1) Cola
                2) Lemon-Lime
                3) Nurse Pepper
                4) Lemonade
                5) Moonkist
                6) Root Beer
                7) Grape Soda
                8) Sweet Tea
                0) Cancel""");
        return getSelection();
    }

    public boolean displayCheckoutScreen(Order order) {
        List<Item> items = order.getOrder();
        System.out.println("-----Checkout-----");
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
        System.out.printf("Total: $%.2f\n", total);
        return yesOrNo("Confirm Checkout? ");
    }

    public void displayOrder(Order order) {
        List<Item> items = order.getOrder();
        System.out.println("-----" + order.getName() + "'s Order-----\n");
        double total = 0;
        for (Item item : items) {
            System.out.println(item.toString());
            if (item instanceof Sandwich)
                total += ((Sandwich) item).getPrice();
            else if (item instanceof Chip)
                total += ((Chip) item).getPrice();
            else if (item instanceof Drink)
                total += ((Drink) item).getPrice();
        }
        System.out.printf("Total: $%.2f\n", total);
    }

    public int getSelection() {
        try {
            return IOUtils.messageAndResponseInt("Make your selection: ");
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean yesOrNo(String message) {
        char selection = IOUtils.messageAndResponse(message + "(Y/N)").toUpperCase().charAt(0);
        return selection == 'Y';
    }

    public int itemSelection(List<Item> items) {
        int i =1;
        for (Item item : items) {
            System.out.print(i + ")");
            System.out.println(item);
            i++;
        }
        return getSelection();
    }

    public int sandwichToppingSelection(List<Topping> toppings) {
        int i =1;
        for (Topping topping : toppings) {
            System.out.print(i + ")");
            System.out.println(topping);
            i++;
        }
        return getSelection();
    }
}
