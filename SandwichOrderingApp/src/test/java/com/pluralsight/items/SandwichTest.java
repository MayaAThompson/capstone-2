package com.pluralsight.items;

import com.pluralsight.Size;
import com.pluralsight.toppings.Cheese;
import com.pluralsight.toppings.CheeseType;
import com.pluralsight.toppings.Meat;
import com.pluralsight.toppings.MeatType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void testDoubleMeatDoubleCheese() {
        Sandwich sandwich = new Sandwich();
        sandwich.size = Size.SMALL;
        sandwich.addTopping(new Cheese(CheeseType.AMERICAN, sandwich.size, false));
        sandwich.addCheese(2);
        sandwich.addTopping(new Meat(MeatType.STEAK, sandwich.size, false));
        sandwich.addMeat(1);

        double expected = 8.05;
        double actual = sandwich.getPrice();

        assertEquals(expected, actual);
    }
}