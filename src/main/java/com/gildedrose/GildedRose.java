package com.gildedrose;

import java.util.Arrays;

class GildedRose {

    Item[] items;
    ItemFactory itemFactory;

    public GildedRose(Item[] items, ItemFactory itemFactory) {
        this.items = items;
        this.itemFactory = itemFactory;
    }

    public void update() {
        Arrays.stream(items).forEach(item -> {
            UpdatableItem updatableItem = itemFactory.createUpdatableItem(item);
            updatableItem.update();
        });
    }

}
