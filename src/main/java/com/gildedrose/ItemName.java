package com.gildedrose;

public enum ItemName {

    GENERIC(Constants.GENERIC),
    AGED_BRIE(Constants.AGED_BRIE),
    BACKSTAGE_PASSES(Constants.BACKSTAGE_PASSES),
    SULFURAS(Constants.SULFURAS);

    private final String name;

    ItemName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class Constants {

        private Constants() {
            throw new UnsupportedOperationException();
        }

        public static final String GENERIC = "Generic item";
        public static final String AGED_BRIE = "Aged Brie";
        public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
        public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    }

}
