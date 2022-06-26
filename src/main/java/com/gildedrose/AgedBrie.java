package com.gildedrose;

import lombok.RequiredArgsConstructor;

import static com.gildedrose.ItemUtils.MINIMUM_ALLOWED_QUALITY;
import static com.gildedrose.ItemUtils.increaseQualityByOne;

@RequiredArgsConstructor
public class AgedBrie implements UpdatableItem {

    private final Item item;

    @Override
    public void update() {
        item.sellIn -= 1;
        increaseQualityByOne(item);

        if (item.sellIn < MINIMUM_ALLOWED_QUALITY) {
            increaseQualityByOne(item);
        }
    }

}
