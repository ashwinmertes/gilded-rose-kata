package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemUtilsTest {

    @Test
    void decreaseQualityByOneIfQualityIsAboveZero() {
        Item item = new Item(ItemName.GENERIC.getName(), 1, 1);

        ItemUtils.decreaseQualityByOne(item);

        assertEquals(0, item.quality);
    }

    @Test
    void qualityDoesNotDecreasesByOneIfQualityIsBelowZero() {
        Item item = new Item(ItemName.GENERIC.getName(), 1, -1);

        ItemUtils.decreaseQualityByOne(item);

        assertEquals(-1, item.quality);
    }

    @Test
    void increaseQualityByOneIfQualityIsBelowFifty() {
        Item item = new Item(ItemName.GENERIC.getName(), 1, 1);

        ItemUtils.increaseQualityByOne(item);

        assertEquals(2, item.quality);
    }

    @Test
    void qualityDoesNotIncreasesByOneIfQualityIsAboveFifity() {
        Item item = new Item(ItemName.GENERIC.getName(), 1, 51);

        ItemUtils.increaseQualityByOne(item);

        assertEquals(51, item.quality);
    }

}
