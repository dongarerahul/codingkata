package com.gildedrose.ivanmoore;

class BackstagePasses extends AbstractGildedRoseItem {
    public BackstagePasses(final Item item) {
        super(item);
    }

    @Override
    public void updateQuality() {
        incrementQuality();
        int expiryTime = 11;
        if (expiresBy(expiryTime)) {
            incrementQuality();

        }

        if (expiresBy(6)) {
            incrementQuality();
        }

        decrementSellIn();

        if (hasExpired()) {
            setNoQuality();
        }
    }
}
