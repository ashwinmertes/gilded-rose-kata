package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemName;
import com.gildedrose.items.Conjured;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ConjuredTest {

    @Test
    void sellInDecreasesByOne() {
        Item item = new Item(ItemName.Constants.CONJURED, 1, 1);
        Conjured conjured = new Conjured(item);

        conjured.update();

        assertEquals(0, conjured.getItem().sellIn);
    }

    @ParameterizedTest
    @CsvSource({
        ItemName.Constants.CONJURED + ", 1, 1, -1",
        ItemName.Constants.CONJURED + ", 1, 0, 0",
        ItemName.Constants.CONJURED + ", 0, 1, -1",
        ItemName.Constants.CONJURED + ", 0, 2, 0",
    })
    void qualityChecks(String name, int sellIn, int quality, int exceptedQuality) {
        Item item = new Item(name, sellIn, quality);
        Conjured conjured = new Conjured(item);

        conjured.update();

        assertEquals(exceptedQuality, conjured.getItem().quality);
    }


}
