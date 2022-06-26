package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SulfurasTest {

    @Test
    void qualityAndSellInNeverChanges() {
        Item item = new Item(ItemName.Constants.SULFURAS, 1, 80);
        Sulfuras sulfuras = new Sulfuras(item);

        sulfuras.update();

        assertEquals(1, sulfuras.item().sellIn);
        assertEquals(80, sulfuras.item().quality);
    }

}
