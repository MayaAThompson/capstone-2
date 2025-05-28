package com.pluralsight.items;

public class Chip extends Item{

    ChipFlavor flavor;

    @Override
    public double getPrice() {
        return 1.5;
    }

    public void addFlavor(int selection) {
        switch (selection) {
            case 1 -> this.flavor = ChipFlavor.PLAIN;
            case 2 -> this.flavor = ChipFlavor.BBQ;
            case 3 -> this.flavor = ChipFlavor.CRACKED_PEPPER;
            case 4 -> this.flavor = ChipFlavor.JALAPENO;
            case 5 -> this.flavor = ChipFlavor.CHILL_RANCH;
            case 6 -> this.flavor = ChipFlavor.CHEESY;
        }
    }
}
