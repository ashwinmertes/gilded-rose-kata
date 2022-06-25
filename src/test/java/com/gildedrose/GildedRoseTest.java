package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class GildedRoseTest {

    private static final String ITEM_GENERIC = "Generic item";
    private static final String ITEM_AGED_BRIE = "Aged Brie";
    private static final String ITEM_BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String ITEM_SULFURAS = "Sulfuras, Hand of Ragnaros";

    @ParameterizedTest
    @CsvSource({
        ITEM_GENERIC + ", 1, 1",
        ITEM_AGED_BRIE + ", 1, 1",
        ITEM_BACKSTAGE_PASSES + ", 1, 1",
    })
    void itemsSellInDecreasesByOne(String name, int sellIn, int quality) {
        GildedRose gildedRose = createGildedRose(name, sellIn, quality);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].sellIn);
    }

    @Test
    void itemSulfurasSellInDoesNotChange() {
        GildedRose gildedRose = createGildedRose(ITEM_SULFURAS, 1, 1);

        gildedRose.updateQuality();

        assertEquals(1, gildedRose.items[0].sellIn);
    }

    @ParameterizedTest
    @CsvSource({
        ITEM_GENERIC + ", 1, 0",
        ITEM_AGED_BRIE + ", 1, 0",
        ITEM_BACKSTAGE_PASSES + ", 1, 0",
    })
    void itemsQualityIsNeverNegative(String name, int sellIn, int quality) {
        GildedRose gildedRose = createGildedRose(name, sellIn, quality);

        gildedRose.updateQuality();

        assertTrue(gildedRose.items[0].quality >= 0);
    }

    @ParameterizedTest
    @CsvSource({
        ITEM_AGED_BRIE + ", 1, 50",
        ITEM_BACKSTAGE_PASSES + ", 1, 50",
    })
    void itemsQualityIsNeverMoreThanFifty(String name, int sellIn, int quality) {
        GildedRose gildedRose = createGildedRose(name, sellIn, quality);

        gildedRose.updateQuality();

        assertFalse(gildedRose.items[0].quality > 50);
    }

    @Test
    void itemGenericQualityDecreasesByOneIfSellInIsAboveZero() {
        GildedRose gildedRose = createGildedRose(ITEM_GENERIC, 1, 1);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void itemGenericQualityDecreasesByTwoOnceSellInHasPassed() {
        GildedRose gildedRose = createGildedRose(ITEM_GENERIC, 0, 2);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void itemAgedBrieQualityIncreasesByOne() {
        GildedRose gildedRose = createGildedRose(ITEM_AGED_BRIE, 1, 1);

        gildedRose.updateQuality();

        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void itemBackstagePassesQualityIncreasesByOneIfSellInMoreThanEleven() {
        GildedRose gildedRose = createGildedRose(ITEM_BACKSTAGE_PASSES, 12, 1);

        gildedRose.updateQuality();

        assertEquals(2, gildedRose.items[0].quality);
    }

    @Test
    void itemBackstagePassesQualityIncreasesByTwoIfSellInLessThanEleven() {
        GildedRose gildedRose = createGildedRose(ITEM_BACKSTAGE_PASSES, 10, 1);

        gildedRose.updateQuality();

        assertEquals(3, gildedRose.items[0].quality);
    }

    @Test
    void itemBackstagePassesQualityIncreasesByThreeIfSellInLessThanSix() {
        GildedRose gildedRose = createGildedRose(ITEM_BACKSTAGE_PASSES, 5, 1);

        gildedRose.updateQuality();

        assertEquals(4, gildedRose.items[0].quality);
    }

    @Test
    void itemBackstagePassesQualityIsZeroIfSellInHasPassed() {
        GildedRose gildedRose = createGildedRose(ITEM_BACKSTAGE_PASSES, 0, 20);

        gildedRose.updateQuality();

        assertEquals(0, gildedRose.items[0].quality);
    }

    @Test
    void itemSulfurasQualityDoesNotChange() {
        GildedRose gildedRose = createGildedRose(ITEM_SULFURAS, 1, 1);

        gildedRose.updateQuality();

        assertEquals(1, gildedRose.items[0].quality);
    }

    private GildedRose createGildedRose(String name, int sellIn, int quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        return new GildedRose(items);
    }

}
