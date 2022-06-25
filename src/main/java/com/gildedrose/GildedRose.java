package com.gildedrose;

class GildedRose {
    private static final int MINIMUM_ALLOWED_QUALITY = 0;
    private static final int MAXIMUM_ALLOWED_QUALITY = 50;
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals(ItemName.SULFURAS.getName())) {
                item.sellIn -= 1;
            }

            switch (item.name) {
                case ItemName.Constants.AGED_BRIE_VALUE -> {
                    increaseQualityByOne(item);

                    if (item.sellIn < MINIMUM_ALLOWED_QUALITY) {
                        increaseQualityByOne(item);
                    }
                }
                case ItemName.Constants.BACKSTAGE_PASSES_VALUE -> {
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
                case ItemName.Constants.SULFURAS_VALUE -> {}
                default -> {
                    decreaseQualityByOne(item);

                    if (item.sellIn < MINIMUM_ALLOWED_QUALITY) {
                        decreaseQualityByOne(item);
                    }
                }
            }

        }
    }

    private void decreaseQualityByOne(Item item) {
        if (item.quality > MINIMUM_ALLOWED_QUALITY) {
            item.quality -= 1;
        }
    }

    private void increaseQualityByOne(Item item) {
        if (item.quality < MAXIMUM_ALLOWED_QUALITY) {
            item.quality += 1;
        }
    }

}
