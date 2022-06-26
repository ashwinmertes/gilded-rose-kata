package com.gildedrose.items;

import com.gildedrose.Item;
import com.gildedrose.ItemUtils;
import com.gildedrose.UpdatableItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class GenericItem implements UpdatableItem {

    private final Item item;

    @Override
    public void update() {
        item.sellIn -= 1;
        decreaseQuality(item);

        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }

    protected void decreaseQuality(Item item) {
        ItemUtils.decreaseQuality(item, 1);
    }

}
