package com.gildedrose.ivanmoore;

public abstract class AbstractGildedRoseItem implements GildedRoseItem {
    private final Item item;

    AbstractGildedRoseItem(final Item item) {
        this.item = item;
    }

    void setNoQuality() {
        item.quality = 0;
    }

    void decrementSellIn() {
        item.sellIn = item.sellIn - 1;
    }

    boolean hasExpired() {
        return expiresBy(0);
    }

    boolean expiresBy(final int expiryTime) {
        return item.sellIn < expiryTime;
    }

    static void decreaseQuality(Item item) {
        item.quality--;
    }

    void decreaseQuality() {
        decreaseQuality(item);
    }

    void incrementQuality() {
        incrementQuality(item);
    }

    static void incrementQuality(Item item) {
        item.quality++;
    }
}
