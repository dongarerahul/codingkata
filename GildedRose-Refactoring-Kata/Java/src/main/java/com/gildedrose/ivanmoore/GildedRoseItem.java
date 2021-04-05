package com.gildedrose.ivanmoore;

public interface GildedRoseItem {
    static GildedRoseItem createGildedRoseItem(Item item) {
        if(isAgedBrie(item)) return new AgedBrie(item);
        if(isBackstagePasses(item)) return new BackstagePasses(item);
        if(isSulfuras(item)) return new Sulfuras(item);

        return new Normal(item) ;
    }

    static boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras");
    }

    static boolean isBackstagePasses(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    static boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    void updateQuality();
}
