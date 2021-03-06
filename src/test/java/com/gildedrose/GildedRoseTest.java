package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    @ParameterizedTest
    @CsvSource({
        ItemName.Constants.GENERIC + ", 1, 1",
        ItemName.Constants.AGED_BRIE + ", 1, 1",
        ItemName.Constants.BACKSTAGE_PASSES + ", 1, 1",
    })
    void itemsSellInDecreasesByOne(String name, int sellIn, int quality) {
        GildedRose gildedRose = createGildedRose(name, sellIn, quality);

        gildedRose.update();

        assertEquals(0, gildedRose.items[0].sellIn);
    }

    @Test
    void itemSulfurasSellInDoesNotChange() {
        GildedRose gildedRose = createGildedRose(ItemName.Constants.SULFURAS, 1, 1);

        gildedRose.update();

        assertEquals(1, gildedRose.items[0].sellIn);
    }

    @ParameterizedTest
    @CsvSource({
        ItemName.Constants.GENERIC + ", 1, 0",
        ItemName.Constants.AGED_BRIE + ", 1, 0",
        ItemName.Constants.BACKSTAGE_PASSES + ", 1, 0",
    })
    void itemsQualityIsNeverNegative(String name, int sellIn, int quality) {
        GildedRose gildedRose = createGildedRose(name, sellIn, quality);

        gildedRose.update();

        assertTrue(gildedRose.items[0].quality >= 0);
    }

    @ParameterizedTest
    @CsvSource({
        ItemName.Constants.AGED_BRIE + ", 1, 50",
        ItemName.Constants.BACKSTAGE_PASSES + ", 1, 50",
    })
    void itemsQualityIsNeverMoreThanFifty(String name, int sellIn, int quality) {
        GildedRose gildedRose = createGildedRose(name, sellIn, quality);

        gildedRose.update();

        assertFalse(gildedRose.items[0].quality > 50);
    }

    @Test
    void itemGenericQualityDecreasesByOneIfSellInIsAboveZero() {
        GildedRose gildedRose = createGildedRose(ItemName.Constants.GENERIC, 1, 1);

        gildedRose.update();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void itemGenericQualityDecreasesByTwoOnceSellInHasPassed() {
        GildedRose gildedRose = createGildedRose(ItemName.Constants.GENERIC, 0, 2);

        gildedRose.update();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void itemAgedBrieQualityIncreasesByOne() {
        GildedRose gildedRose = createGildedRose(ItemName.Constants.AGED_BRIE, 1, 1);

        gildedRose.update();

        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void itemBackstagePassesQualityIncreasesByOneIfSellInMoreThanEleven() {
        GildedRose gildedRose = createGildedRose(ItemName.Constants.BACKSTAGE_PASSES, 12, 1);

        gildedRose.update();

        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void itemBackstagePassesQualityIncreasesByTwoIfSellInLessThanEleven() {
        GildedRose gildedRose = createGildedRose(ItemName.Constants.BACKSTAGE_PASSES, 10, 1);

        gildedRose.update();

        assertEquals(3, gildedRose.items[0].quality);
    }

    @Test
    void itemBackstagePassesQualityIncreasesByThreeIfSellInLessThanSix() {
        GildedRose gildedRose = createGildedRose(ItemName.Constants.BACKSTAGE_PASSES, 5, 1);

        gildedRose.update();

        assertEquals(4, gildedRose.items[0].quality);
    }

    @Test
    void itemBackstagePassesQualityIsZeroIfSellInHasPassed() {
        GildedRose gildedRose = createGildedRose(ItemName.Constants.BACKSTAGE_PASSES, 0, 20);

        gildedRose.update();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void itemSulfurasQualityDoesNotChange() {
        GildedRose gildedRose = createGildedRose(ItemName.Constants.SULFURAS, 1, 1);

        gildedRose.update();

        assertEquals(1, gildedRose.items[0].quality);
    }

    private GildedRose createGildedRose(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        return new GildedRose(items, new ItemFactory());
    }

}
