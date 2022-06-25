package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> {
            if (!item.name.equals(ItemName.AGED_BRIE.getName()) && !item.name.equals(ItemName.BACKSTAGE_PASSES.getName())) {
                if (item.quality > 0 && !item.name.equals(ItemName.SULFURAS.getName())) {
                    item.quality = item.quality - 1;
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(ItemName.BACKSTAGE_PASSES.getName())) {
                        if (item.sellIn < 11 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }

                        if (item.sellIn < 6 && item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }

            if (!item.name.equals(ItemName.SULFURAS.getName())) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < 0) {
                if (!item.name.equals(ItemName.AGED_BRIE.getName())) {
                    if (!item.name.equals(ItemName.BACKSTAGE_PASSES.getName())) {
                        if (item.quality > 0 && !item.name.equals(ItemName.SULFURAS.getName())) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        });
    }
}
