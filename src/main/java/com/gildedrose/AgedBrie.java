package com.gildedrose;

import static com.gildedrose.ItemUtils.increaseQualityByOne;

public record AgedBrie(Item item) implements UpdatableItem {

    @Override
    public void update() {
        item.sellIn -= 1;
        increaseQualityByOne(item);

        if (item.sellIn < 0) {
            increaseQualityByOne(item);
        }
    }

}
