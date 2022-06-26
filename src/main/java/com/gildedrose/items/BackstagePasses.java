package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.UpdatableItem;

import static com.gildedrose.ItemUtils.MINIMUM_ALLOWED_QUALITY;
import static com.gildedrose.ItemUtils.increaseQuality;

public record BackstagePasses(Item item) implements UpdatableItem {

    @Override
    public void update() {
        item.sellIn -= 1;
        increaseQuality(item, 1);

        if (item.sellIn < 10) {
            increaseQuality(item, 1);
        }

        if (item.sellIn < 5) {
            increaseQuality(item, 1);
        }

        if (item.sellIn < 0) {
            item.quality = MINIMUM_ALLOWED_QUALITY;
        }
    }

}
