package com.gildedrose;

import lombok.AllArgsConstructor;

import java.util.Arrays;

@AllArgsConstructor
class GildedRose {

    Item[] items;
    ItemFactory itemFactory;

    public void update() {
        Arrays.stream(items).forEach(item -> {
            UpdatableItem updatableItem = itemFactory.createUpdatableItem(item);
            updatableItem.update();
        });
    }

}
