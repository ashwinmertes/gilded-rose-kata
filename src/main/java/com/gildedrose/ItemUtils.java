package com.gildedrose;

public class ItemUtils {

    private ItemUtils() {
        throw new UnsupportedOperationException();
    }

    public static final int MINIMUM_ALLOWED_QUALITY = 0;
    private static final int MAXIMUM_ALLOWED_QUALITY = 50;

    public static void decreaseQualityByOne(Item item) {
        if (item.quality > MINIMUM_ALLOWED_QUALITY) {
            item.quality -= 1;
        }
    }

    public static void increaseQualityByOne(Item item) {
        if (item.quality < MAXIMUM_ALLOWED_QUALITY) {
            item.quality += 1;
        }
    }

}
