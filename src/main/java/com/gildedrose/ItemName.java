package com.gildedrose;

public enum ItemName {

    GENERIC(Constants.GENERIC_VALUE),
    AGED_BRIE(Constants.AGED_BRIE_VALUE),
    BACKSTAGE_PASSES(Constants.BACKSTAGE_PASSES_VALUE),
    SULFURAS(Constants.SULFURAS_VALUE);

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

        public static final String GENERIC_VALUE = "Generic item";
        public static final String AGED_BRIE_VALUE = "Aged Brie";
        public static final String BACKSTAGE_PASSES_VALUE = "Backstage passes to a TAFKAL80ETC concert";
        public static final String SULFURAS_VALUE = "Sulfuras, Hand of Ragnaros";
    }

}
