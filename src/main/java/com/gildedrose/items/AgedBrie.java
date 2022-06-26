package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;

import static com.gildedrose.ItemUtils.increaseQuality;

public record AgedBrie(Item item) implements UpdatableItem {

    @Override
    public void update() {
        item.sellIn -= 1;
        increaseQuality(item, 1);

        if (item.sellIn < 0) {
            increaseQuality(item, 1);
        }
    }

}
