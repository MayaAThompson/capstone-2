package com.pluralsight.items;

import com.pluralsight.Size;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.CheeseType;
import com.pluralsight.utils.IOUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void addCheese() {
        Sandwich sandwich = new Sandwich();
        sandwich.size = Size.SMALL;
        sandwich.addTopping(new Cheese(CheeseType.AMERICAN, Size.SMALL, false));
        sandwich.addCheese(2);

        double expected = 6.55;
        double actual = sandwich.getPrice();

        assertEquals(expected, actual);
    }
}