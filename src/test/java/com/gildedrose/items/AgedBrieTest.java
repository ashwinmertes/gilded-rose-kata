package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemName;
import com.gildedrose.items.AgedBrie;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AgedBrieTest {

    @Test
    void sellInDecreasesByOne() {
        Item item = new Item(ItemName.Constants.AGED_BRIE, 1, 1);
        AgedBrie agedBrie = new AgedBrie(item);

        agedBrie.update();

        assertEquals(0, agedBrie.item().sellIn);
    }

    @ParameterizedTest
    @CsvSource({
        ItemName.Constants.AGED_BRIE + ", 0, 1, 3",
        ItemName.Constants.AGED_BRIE + ", 1, 1, 2",
        ItemName.Constants.AGED_BRIE + ", 1, 50, 50",
        ItemName.Constants.AGED_BRIE + ", 1, 51, 51",
    })
    void qualityChecks(String name, int sellIn, int quality, int exceptedQuality) {
        Item item = new Item(name, sellIn, quality);
        AgedBrie agedBrie = new AgedBrie(item);

        agedBrie.update();

        assertEquals(exceptedQuality, agedBrie.item().quality);
    }

}
