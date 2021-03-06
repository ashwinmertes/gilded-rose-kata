package com.gildedrose;

import com.gildedrose.items.*;

public class ItemFactory {

    public UpdatableItem createUpdatableItem(Item item) {
        return switch (item.name) {
            case ItemName.Constants.AGED_BRIE -> new AgedBrie(item);
            case ItemName.Constants.BACKSTAGE_PASSES -> new BackstagePasses(item);
            case ItemName.Constants.SULFURAS -> new Sulfuras(item);
            case ItemName.Constants.CONJURED -> new Conjured(item);
            default -> new GenericItem(item);
        };
    }

}
