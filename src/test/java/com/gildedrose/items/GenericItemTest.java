package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemName;
import com.gildedrose.items.GenericItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GenericItemTest {

    @Test
    void sellInDecreasesByOne() {
        Item item = new Item(ItemName.Constants.GENERIC, 1, 1);
        GenericItem genericItem = new GenericItem(item);

        genericItem.update();

        assertEquals(0, genericItem.getItem().sellIn);
    }

    @ParameterizedTest
    @CsvSource({
        ItemName.Constants.GENERIC + ", 1, 1, 0",
        ItemName.Constants.GENERIC + ", 1, 0, 0",
        ItemName.Constants.GENERIC + ", 0, 1, 0",
        ItemName.Constants.GENERIC + ", 0, 2, 0",
    })
    void qualityChecks(String name, int sellIn, int quality, int exceptedQuality) {
        Item item = new Item(name, sellIn, quality);
        GenericItem genericItem = new GenericItem(item);

        genericItem.update();

        assertEquals(exceptedQuality, genericItem.getItem().quality);
    }

}
