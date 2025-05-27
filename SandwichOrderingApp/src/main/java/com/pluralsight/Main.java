package com.pluralsight;

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
                case 1 -> processSandwich(order);
                case 2 -> processSigSandwich(order);
                case 3 -> processDrink(order);
                case 4 -> processChip(order);
                case 5 -> processCheckout(order);
                case 0 -> keepRunning = false;
            }
        }
    }

    public void processSandwich(Order order) {

    }

    public void processSigSandwich(Order order) {

    }

    public void processDrink(Order order) {

    }

    public void processChip(Order order) {

    }

    public void processCheckout(Order order) {

    }
}
