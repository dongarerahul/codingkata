package com.emily;

public class BackstagePass extends Item {

    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    protected void doUpdateQuality() {
        if (quality < MAX_QUALITY) {
            quality++;

            increaseQuality_tmp();
        }

        sellIn--;

        if (sellIn < 0) {
            quality = 0;
        }
    }

    private void increaseQuality_tmp() {
        if (sellIn < CLOSE_TO_EXPIRY) {
            increaseQuality();
        }

        if (sellIn < FAR_FROM_EXPIRY) {
            increaseQuality();
        }
    }

    private void increaseQuality() {
        if (quality < MAX_QUALITY) {
            quality++;
        }
    }
}
