package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemUtilsTest {

    @Test
    void decreaseQualityByOneIfQualityIsAboveZero() {
        Item item = new Item(ItemName.GENERIC.getName(), 1, 1);

        ItemUtils.decreaseQuality(item, 1);

        assertEquals(0, item.quality);
    }

    @Test
    void qualityDoesNotDecreasesByOneIfQualityIsBelowZero() {
        Item item = new Item(ItemName.GENERIC.getName(), 1, -1);

        ItemUtils.decreaseQuality(item, 1);

        assertEquals(-1, item.quality);
    }

    @Test
    void increaseQualityByOneIfQualityIsBelowFifty() {
        Item item = new Item(ItemName.GENERIC.getName(), 1, 1);

        ItemUtils.increaseQuality(item, 1);

        assertEquals(2, item.quality);
    }

    @Test
    void qualityDoesNotIncreasesByOneIfQualityIsAboveFifity() {
        Item item = new Item(ItemName.GENERIC.getName(), 1, 51);

        ItemUtils.increaseQuality(item, 1);

        assertEquals(51, item.quality);
    }

}
