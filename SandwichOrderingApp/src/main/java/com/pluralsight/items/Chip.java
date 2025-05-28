package com.pluralsight.items;

public class Chip extends Item{

    public ChipFlavor getFlavor() {
        return flavor;
    }

    public void setFlavor(ChipFlavor flavor) {
        this.flavor = flavor;
    }

    private ChipFlavor flavor;

    @Override
    public double getPrice() {
        return 1.5;
    }

    @Override
    public String getName() {
        return this.flavor + " CHIPS";
    }

    public void setFlavor(int selection) {
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
