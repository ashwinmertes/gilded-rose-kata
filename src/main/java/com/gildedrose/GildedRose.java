package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    private static final int MINIMUM_ALLOWED_QUALITY = 0;
    private static final int MAXIMUM_ALLOWED_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> {
            if (!item.name.equals(ItemName.AGED_BRIE.getName()) && !item.name.equals(ItemName.BACKSTAGE_PASSES.getName())) {
                if (item.quality > MINIMUM_ALLOWED_QUALITY && !item.name.equals(ItemName.SULFURAS.getName())) {
                    item.quality = item.quality - 1;
                }
            } else {
                if (item.quality < MAXIMUM_ALLOWED_QUALITY) {
                    item.quality = item.quality + 1;

                    if (item.name.equals(ItemName.BACKSTAGE_PASSES.getName())) {
                        if (item.sellIn < 11 && item.quality < MAXIMUM_ALLOWED_QUALITY) {
                            item.quality = item.quality + 1;
                        }

                        if (item.sellIn < 6 && item.quality < MAXIMUM_ALLOWED_QUALITY) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }

            if (!item.name.equals(ItemName.SULFURAS.getName())) {
                item.sellIn = item.sellIn - 1;
            }

            if (item.sellIn < MINIMUM_ALLOWED_QUALITY) {
                if (!item.name.equals(ItemName.AGED_BRIE.getName())) {
                    if (!item.name.equals(ItemName.BACKSTAGE_PASSES.getName())) {
                        if (item.quality > MINIMUM_ALLOWED_QUALITY && !item.name.equals(ItemName.SULFURAS.getName())) {
                            item.quality = item.quality - 1;
                        }
                    } else {
                        item.quality = MINIMUM_ALLOWED_QUALITY;
                    }
                } else {
                    if (item.quality < MAXIMUM_ALLOWED_QUALITY) {
                        item.quality = item.quality + 1;
                    }
                }
            }
        });
    }
}
