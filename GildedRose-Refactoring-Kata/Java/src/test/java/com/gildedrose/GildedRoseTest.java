package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.approvaltests.combinations.CombinationApprovals.verifyAllCombinations;

class GildedRoseTest {

    @Test
    void foo() {
        verifyAllCombinations(
                this :: doUpdateQuality,
                new String[]  {"foo"},
                new Integer[] { -1  },
                new Integer[] { 0   } );
    }

    private String doUpdateQuality (String name, Integer sellIn, Integer quality) {
        Item[] items = new Item[]{new Item(name, sellIn, quality)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0].toString();
    }
}
