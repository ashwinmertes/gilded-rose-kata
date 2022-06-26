package com.gildedrose;

public class ItemUtils {

    private ItemUtils() {
        throw new UnsupportedOperationException();
    }

    public static final int MINIMUM_ALLOWED_QUALITY = 0;
    private static final int MAXIMUM_ALLOWED_QUALITY = 50;

    public static void decreaseQuality(Item item, int amount) {
        if (item.quality > MINIMUM_ALLOWED_QUALITY) {
            item.quality -= amount;
        }
    }

    public static void increaseQuality(Item item, int amount) {
        if (item.quality < MAXIMUM_ALLOWED_QUALITY) {
            item.quality += amount;
        }
    }

}
