package com.gildedrose;

import static com.gildedrose.ItemUtils.MINIMUM_ALLOWED_QUALITY;
import static com.gildedrose.ItemUtils.decreaseQualityByOne;

public record GenericItem(Item item) implements UpdatableItem {

    @Override
    public void update() {
        item.sellIn -= 1;

        decreaseQualityByOne(item);

        if (item.sellIn < MINIMUM_ALLOWED_QUALITY) {
            decreaseQualityByOne(item);
        }
    }

}
