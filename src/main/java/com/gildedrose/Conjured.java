package com.gildedrose;

public class Conjured extends GenericItem {

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void decreaseQuality(Item item) {
        ItemUtils.decreaseQuality(item, 2);
    }

}
