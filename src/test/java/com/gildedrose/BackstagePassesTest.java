package com.gildedrose;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class BackstagePassesTest {

    @Test
    void sellInDecreasesByOne() {
        Item item = new Item(ItemName.Constants.BACKSTAGE_PASSES, 1, 1);
        BackstagePasses backstagePasses = new BackstagePasses(item);

        backstagePasses.update();

        assertEquals(0, backstagePasses.item().sellIn);
    }

    @ParameterizedTest
    @CsvSource({
        ItemName.Constants.BACKSTAGE_PASSES + ", 12, 1, 2",
        ItemName.Constants.BACKSTAGE_PASSES + ", 10, 1, 3",
        ItemName.Constants.BACKSTAGE_PASSES + ", 5, 1, 4",
        ItemName.Constants.BACKSTAGE_PASSES + ", 0, 20, 0",
    })
    void qualityChecks(String name, int sellIn, int quality, int exceptedQuality) {
        Item item = new Item(name, sellIn, quality);
        BackstagePasses backstagePasses = new BackstagePasses(item);

        backstagePasses.update();

        assertEquals(exceptedQuality, backstagePasses.item().quality);
    }

}
