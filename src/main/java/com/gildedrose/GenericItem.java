package com.gildedrose;

import lombok.RequiredArgsConstructor;

import static com.gildedrose.ItemUtils.MINIMUM_ALLOWED_QUALITY;
import static com.gildedrose.ItemUtils.decreaseQualityByOne;

@RequiredArgsConstructor
public class GenericItem implements UpdatableItem {

    private final Item item;

    @Override
    public void update() {
        item.sellIn -= 1;

        decreaseQualityByOne(item);

        if (item.sellIn < MINIMUM_ALLOWED_QUALITY) {
            decreaseQualityByOne(item);
        }
    }

}
