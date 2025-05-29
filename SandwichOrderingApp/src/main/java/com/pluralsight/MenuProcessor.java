package com.pluralsight;

import com.pluralsight.items.*;
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
                case 1 -> order.addSandwich(processSandwich(new Sandwich()));
                case 2 -> order.addSandwich(processSandwich(processSigSandwich()));
                case 3 -> order.addDrink(processDrink());
                case 4 -> order.addChip(processChip());
                case 5 -> userInterface.displayOrder(order);
                case 6 -> order.removeItem(userInterface.itemSelection(order.getOrder()));
                case 9 -> {
                    processCheckout(order);
                    keepRunning = false;
                }
                case 0 -> {
                    order = null;
                    keepRunning = false;
                }
                default -> System.out.println("Please select an available option.");
            }
        }
    }

    public Sandwich processSandwich(Sandwich sandwich) {
        if (!sandwich.isSignature()) {
            sandwich.selectSize(userInterface.sizeSelection());
            sandwich.addBread(userInterface.breadSelection());
            sandwich.selectToasted(userInterface.yesOrNo("Would you like your sandwich toasted? "));
        }
        boolean keepRunning = true;
        while (keepRunning) {
            int selection = userInterface.sandwichScreenSelection();
            switch (selection) {
                case 1 -> sandwich.addMeat(userInterface.meatSelection());
                case 2 -> sandwich.addCheese(userInterface.cheeseSelection());
                case 3 -> sandwich.addRegularTopping(userInterface.regularToppingSelection());
                case 4 ->
                        sandwich.addSauce(userInterface.sauceSelection(), userInterface.yesOrNo("Want it on the side? "));
                case 5 -> sandwich.removeTopping(userInterface.existingToppingSelection(sandwich.getToppings()));
                case 9 -> keepRunning = false;
                case 0 -> {
                    sandwich = null;
                    keepRunning = false;
                }
                default -> System.out.println("Please select an available option.");
            }
        }
        return sandwich;
    }

    public Sandwich processSigSandwich() {
        Sandwich sandwich = null;
        int selection = userInterface.signatureSandwichSelection();
        while(sandwich == null) {
            switch (selection) {
                case 1 -> sandwich = new ReubenSandwich(userInterface.sizeSelection());
                case 2 -> sandwich = new CubanSandwich(userInterface.sizeSelection());
                case 3 -> sandwich = new BltSandwich(userInterface.sizeSelection());
                case 4 -> sandwich = new MushroomSwissSandwich(userInterface.sizeSelection());
                default -> System.out.println("Please select one of our delicious sandwiches!");
            }
        }

        return sandwich;
    }

    public Drink processDrink() {
        Drink drink = new Drink();
        do
            drink.setSize(userInterface.sizeSelection());
        while (drink.getSize() == null);
        do
            drink.setFlavor(userInterface.drinkSelection());
        while (drink.getFlavor() == null);
        return drink;
    }

    public Chip processChip() {
        Chip chip = new Chip();
        do
            chip.setFlavor(userInterface.chipSelection());
        while (chip.getFlavor() == null);
        return chip;
    }

    public void processCheckout(Order order) {
        boolean confirm = userInterface.displayCheckoutScreen(order);
        if (confirm) {
            FileManager.saveReceipt(order);
            System.out.println("Order complete! We will have it ready for you shortly.");
        }
        else
            System.out.println("Checkout cancelled.");
    }
}
