package com.gildedrose.ivanmoore;

class AgedBrie extends AbstractGildedRoseItem {
    public AgedBrie(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();

        decrementSellIn();

        if (hasExpired()) {
            incrementQuality();
        }
    }
}
