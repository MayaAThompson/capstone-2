package com.pluralsight;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Sandwich;
import com.pluralsight.utils.IOUtils;

public class MenuProcessor {

    UserInterface userInterface = new UserInterface();

    public void homeScreen() {
        boolean keepMenuRunning = true;
        while (keepMenuRunning) {
            int selection = userInterface.homeScreenSelection();
            switch (selection) {
                case 1 -> processOrder();
                case 0 -> keepMenuRunning = false;
            }
        }
    }

    public void processOrder() {
        Order order = new Order(IOUtils.messageAndResponse("What is your name? ", true));
        boolean keepRunning = true;
        while (keepRunning) {
            int selection = userInterface.orderScreenSelection();
            switch (selection) {
                case 1 -> order.addSandwich(processSandwich());
                case 2 -> order.addSandwich(processSigSandwich());
                case 3 -> order.addDrink(processDrink());
                case 4 -> order.addChip(processChip());
                case 5 -> userInterface.displayOrder(order);
                case 6 -> order.removeItem(userInterface.itemSelection(order.getOrder()));
                case 9 -> {
                    processCheckout(order);
                    keepRunning = false;
                }
                case 0 -> keepRunning = false;
            }
        }
    }

    public Sandwich processSandwich() {
        Sandwich sandwich = new Sandwich();
        sandwich.addSize(userInterface.sizeSelection());
        sandwich.addBread(userInterface.breadSelection());
        sandwich.selectToasted(userInterface.yesOrNo("Would you like your sandwich toasted? "));
        boolean keepRunning = true;
        while (keepRunning) {
            int selection = userInterface.sandwichScreenSelection();
            switch (selection) {
                case 1 -> sandwich.addMeat(userInterface.meatSelection());
                case 2 -> sandwich.addCheese(userInterface.cheeseSelection());
                case 3 -> sandwich.addRegularTopping(userInterface.regularToppingSelection());
                case 4 ->
                        sandwich.addSauce(userInterface.sauceSelection(), userInterface.yesOrNo("Want it on the side? "));
                case 5 -> sandwich.removeTopping(userInterface.sandwichToppingSelection(sandwich.getToppings()));
                case 9 -> keepRunning = false;
                case 0 -> {
                    sandwich = null;
                    keepRunning = false;
                }
                default -> System.out.println("Please select and available option.");
            }
        }
        return sandwich;
    }

    public Sandwich processSigSandwich() {
        return null;
    }

    public Drink processDrink() {
        Drink drink = new Drink();
        drink.setSize(userInterface.sizeSelection());
        drink.setFlavor(userInterface.drinkSelection());
        return drink;
    }

    public Chip processChip() {
        Chip chip = new Chip();
        chip.setFlavor(userInterface.chipSelection());
        return chip;
    }

    public void processCheckout(Order order) {
        boolean confirm = userInterface.displayCheckoutScreen(order);
        if (confirm)
            FileManager.saveReceipt(order);
    }
}
