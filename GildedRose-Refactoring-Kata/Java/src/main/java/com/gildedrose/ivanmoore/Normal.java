package com.gildedrose.ivanmoore;

class Normal extends AbstractGildedRoseItem {
    public Normal(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        decreaseQuality();

        decrementSellIn();

        if (hasExpired()) {
            decreaseQuality();
        }
    }
}
