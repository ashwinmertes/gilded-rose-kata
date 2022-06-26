package com.gildedrose;

import static com.gildedrose.ItemUtils.MINIMUM_ALLOWED_QUALITY;
import static com.gildedrose.ItemUtils.increaseQualityByOne;

public record BackstagePasses(Item item) implements UpdatableItem {

    @Override
    public void update() {
        item.sellIn -= 1;
        increaseQualityByOne(item);

        if (item.sellIn < 10) {
            increaseQualityByOne(item);
        }

        if (item.sellIn < 5) {
            increaseQualityByOne(item);
        }

        if (item.sellIn < 0) {
            item.quality = MINIMUM_ALLOWED_QUALITY;
        }
    }

}
