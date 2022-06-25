package com.gildedrose;

import static com.gildedrose.ItemUtils.MINIMUM_ALLOWED_QUALITY;
import static com.gildedrose.ItemUtils.increaseQualityByOne;

public class BackstagePasses implements UpdatableItem {

    private final Item item;

    public BackstagePasses(Item item) {
        this.item = item;
    }

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

        if (item.sellIn < MINIMUM_ALLOWED_QUALITY) {
            item.quality = MINIMUM_ALLOWED_QUALITY;
        }
    }

}
