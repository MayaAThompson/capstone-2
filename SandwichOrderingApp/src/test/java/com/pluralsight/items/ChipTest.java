package com.pluralsight.items;

import com.pluralsight.Order;
import org.junit.jupiter.api.Test;

import static com.pluralsight.items.ChipFlavor.BBQ;
import static org.junit.jupiter.api.Assertions.*;

class ChipTest {

    @Test
    void getName() {
        Chip chip = new Chip();
        chip.setFlavor(BBQ);

        String expected = "BBQ CHIPS 1.5";

        assertEquals(expected, chip.toString());
    }

    @Test
    void addChipTest() {
        Order order = new Order("Maya");
        Chip chip = new Chip();
        chip.setFlavor(BBQ);
        order.addChip(chip);

    }
}