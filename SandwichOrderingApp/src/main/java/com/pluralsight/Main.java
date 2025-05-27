package com.pluralsight;

import com.pluralsight.items.Chip;
import com.pluralsight.items.Drink;
import com.pluralsight.items.Sandwich;
import com.pluralsight.utils.IOUtils;

public class Main {

    UserInterface userInterface = new UserInterface();

    public static void main(String[] args) {
        System.out.println("Welcome to DELI-cious!");




    }

    public void homeScreen() {
        boolean keepMenuRunning = true;
        while (keepMenuRunning) {
            userInterface.displayHomeScreen();
            int selection = userInterface.getSelection();
            switch (selection) {
                case 1 -> processOrder();
                case 0 -> keepMenuRunning = false;
            }
        }
    }

    public void processOrder() {
        Order order = new Order("order1");
        boolean keepRunning = true;
        while (keepRunning) {
            userInterface.displayOrderScreen();
            int selection = userInterface.getSelection();
            switch (selection) {
                case 1 -> order.addSandwich(processSandwich());
                case 2 -> order.addSandwich(processSigSandwich());
                case 3 -> order.addDrink(processDrink());
                case 4 -> order.addChip(processChip());
                case 5 -> processCheckout(order);
                case 0 -> keepRunning = false;
            }
        }
    }

    public Sandwich processSandwich() {
        Sandwich sandwich = new Sandwich();
        sandwich.selectSize();
        sandwich.selectBread();
        sandwich.selectToasted();
        boolean keepRunning = true;
        while (keepRunning) {
            userInterface.displaySandwichScreen();
            int selection = userInterface.getSelection();
            switch (selection) {
                case 1 -> System.out.println("not here");
                case 2 -> System.out.println("not here either");

            }
        }
        return sandwich;
    }

    public Sandwich processSigSandwich() {
        return null;
    }

    public Drink processDrink() {
        return null;
    }

    public Chip processChip() {
        return null;
    }

    public void processCheckout(Order order) {

    }
}
