package com.pluralsight;

import com.pluralsight.items.*;
import com.pluralsight.utils.IOUtils;

public class MenuProcessor {

    private final UserInterface USER_INTERFACE = new UserInterface();

    public void homeScreen() {
        boolean keepMenuRunning = true;
        while (keepMenuRunning) {
            int selection = USER_INTERFACE.homeScreenSelection();
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
            int selection = USER_INTERFACE.orderScreenSelection();
            switch (selection) {
                case 1 -> order.addSandwich(processSandwich(new Sandwich()));
                case 2 -> order.addSandwich(processSandwich(processSigSandwich()));
                case 3 -> order.addDrink(processDrink());
                case 4 -> order.addChip(processChip());
                case 5 -> USER_INTERFACE.displayOrder(order);
                case 6 -> order.removeItem(USER_INTERFACE.itemSelection(order.getOrder()));
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
            sandwich.selectSize(USER_INTERFACE.sizeSelection());
            sandwich.addBread(USER_INTERFACE.breadSelection());
            sandwich.selectToasted(USER_INTERFACE.yesOrNo("Would you like your sandwich toasted? "));
        }
        boolean keepRunning = true;
        while (keepRunning) {
            int selection = USER_INTERFACE.sandwichScreenSelection();
            switch (selection) {
                case 1 -> sandwich.addMeat(USER_INTERFACE.meatSelection());
                case 2 -> sandwich.addCheese(USER_INTERFACE.cheeseSelection());
                case 3 -> sandwich.addRegularTopping(USER_INTERFACE.regularToppingSelection());
                case 4 ->
                        sandwich.addSauce(USER_INTERFACE.sauceSelection(), USER_INTERFACE.yesOrNo("Want it on the side? "));
                case 5 -> sandwich.removeTopping(USER_INTERFACE.existingToppingSelection(sandwich.getToppings()));
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
        int selection = USER_INTERFACE.signatureSandwichSelection();
        while (sandwich == null) {
            switch (selection) {
                case 1 -> sandwich = new ReubenSandwich(USER_INTERFACE.sizeSelection());
                case 2 -> sandwich = new CubanSandwich(USER_INTERFACE.sizeSelection());
                case 3 -> sandwich = new BltSandwich(USER_INTERFACE.sizeSelection());
                case 4 -> sandwich = new MushroomSwissSandwich(USER_INTERFACE.sizeSelection());
                default -> System.out.println("Please select one of our delicious sandwiches!");
            }
        }

        return sandwich;
    }

    public Drink processDrink() {
        Drink drink = new Drink();
        do
            drink.setSize(USER_INTERFACE.sizeSelection());
        while (drink.getSize() == null);
        do
            drink.setFlavor(USER_INTERFACE.drinkSelection());
        while (drink.getFlavor() == null);
        return drink;
    }

    public Chip processChip() {
        Chip chip = new Chip();
        do
            chip.setFlavor(USER_INTERFACE.chipSelection());
        while (chip.getFlavor() == null);
        return chip;
    }

    public void processCheckout(Order order) {
        boolean confirm = USER_INTERFACE.displayCheckoutScreen(order);
        if (confirm) {
            FileManager.saveReceipt(order);
            System.out.println("Order complete! We will have it ready for you shortly.");
        } else
            System.out.println("Checkout cancelled.");
    }
}
