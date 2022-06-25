package com.gildedrose;

import static com.gildedrose.ItemUtils.MINIMUM_ALLOWED_QUALITY;
import static com.gildedrose.ItemUtils.decreaseQualityByOne;

public class GenericItem implements UpdatableItem {

    private final Item item;

    public GenericItem(Item item) {
        this.item = item;
    }

    @Override
    public void update() {
        item.sellIn -= 1;

        decreaseQualityByOne(item);

        if (item.sellIn < MINIMUM_ALLOWED_QUALITY) {
            decreaseQualityByOne(item);
        }
    }

}
