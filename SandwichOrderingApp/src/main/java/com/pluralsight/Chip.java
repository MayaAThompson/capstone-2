package com.pluralsight;

public class Chip extends Item{

    ChipFlavor flavor;

    @Override
    public double getPrice() {
        return 1.5;
    }
}
