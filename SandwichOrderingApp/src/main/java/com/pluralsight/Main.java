package com.pluralsight;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Sandwich;

public class Main {

    UserInterface userInterface = new UserInterface();

    public static void main(String[] args) {
        System.out.println("Welcome to DELI-cious!");
        UserInterface mainUI = new UserInterface();
        Main main = new Main();
        main.homeScreen(mainUI.homeScreenSelection());
    }

    public void homeScreen(int selection) {
        boolean keepMenuRunning = true;
        while (keepMenuRunning) {

            switch (selection) {
                case 1 -> processOrder(userInterface.orderScreenSelection());
                case 0 -> keepMenuRunning = false;
            }
        }
    }

    public void processOrder(int selection) {
        Order order = new Order("order1");
        boolean keepRunning = true;
        while (keepRunning) {
            switch (selection) {
                case 1 -> order.addSandwich(processSandwich());
                case 2 -> order.addSandwich(processSigSandwich());
                case 3 -> order.addDrink(processDrink());
                case 4 -> order.addChip(processChip());
                case 5 -> userInterface.displayOrder(order.items);
//                case 6 -> order.removeItem();
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
                case 4 -> sandwich.addSauce(userInterface.sauceSelection(), userInterface.yesOrNo("Want it on the side? "));
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
        drink.addSize(userInterface.sizeSelection());
        drink.addFlavor(userInterface.drinkSelection());
        return drink;
    }

    public Chip processChip() {
        Chip chip = new Chip();
        chip.addFlavor(userInterface.chipSelection());
        return null;
    }

    public void processCheckout(Order order) {
        boolean confirm = userInterface.displayCheckoutScreen(order.items);
        if (confirm)
            FileManager.saveReceipt(order);
    }
}
