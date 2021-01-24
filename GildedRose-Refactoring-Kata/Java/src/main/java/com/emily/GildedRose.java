package com.emily;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void doUpdateQuality() {
        for (int i = 0; i < items.length; i++) {
            items[i].doUpdateQuality();
        }
    }

}
