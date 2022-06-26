package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemFactoryTest {

    private ItemFactory itemFactory;

    @BeforeEach
    void setUp() {
        itemFactory = new ItemFactory();
    }

    @Test
    void genericItemNameReturnsGenericItemObject() {
        Item item = new Item(ItemName.Constants.GENERIC, 1, 1);

        UpdatableItem updatableItem = itemFactory.createUpdatableItem(item);

        assertInstanceOf(GenericItem.class, updatableItem);
    }

    @Test
    void agedBrieNameReturnsAgedBrieObject() {
        Item item = new Item(ItemName.Constants.AGED_BRIE, 1, 1);

        UpdatableItem updatableItem = itemFactory.createUpdatableItem(item);

        assertInstanceOf(AgedBrie.class, updatableItem);
    }

    @Test
    void backstagePassesNameReturnsBackstagePassesObject() {
        Item item = new Item(ItemName.Constants.BACKSTAGE_PASSES, 1, 1);

        UpdatableItem updatableItem = itemFactory.createUpdatableItem(item);

        assertInstanceOf(BackstagePasses.class, updatableItem);
    }

    @Test
    void sulfurasItemNameReturnsSulfurasItemObject() {
        Item item = new Item(ItemName.Constants.SULFURAS, 1, 1);

        UpdatableItem updatableItem = itemFactory.createUpdatableItem(item);

        assertInstanceOf(Sulfuras.class, updatableItem);
    }

    @Test
    void conjuredItemNameReturnsConjuredItemObject() {
        Item item = new Item(ItemName.Constants.CONJURED, 1, 1);

        UpdatableItem updatableItem = itemFactory.createUpdatableItem(item);

        assertInstanceOf(Conjured.class, updatableItem);
    }

}
