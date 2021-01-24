package com.gildedrose.christianClausen;

import org.junit.jupiter.api.Test;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

class GildedRoseTest {

    @Test
    void foo() {
        verifyAllCombinations(
                this :: doUpdateQuality,
                new String[]  {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
                new Integer[] { -1, 0, 2, 6, 11 },
                new Integer[] { 0, 1, 49, 50 } );
    }

    private String doUpdateQuality (String name, Integer sellIn, Integer quality) {
        com.emily.Item[] items = new com.emily.Item[]{com.emily.Item.createItem(name, sellIn, quality)};
        com.emily.GildedRose app = new com.emily.GildedRose(items);
        app.doUpdateQuality();
        return app.items[0].toString();
    }
}
