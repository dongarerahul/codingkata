package com.gildedrose.christianClausen;

public class Item {

    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    public static final int MAX_QUALITY = 50;
    public static final int FAR_FROM_EXPIRY = 11;
    public static final int CLOSE_TO_EXPIRY = 6;
    public static final int MIN_QUALITY = 0;

    public final String name;
    public int sellIn;
    public int quality;

    private IsAgedBrie isAgedBrie;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        isAgedBrie = name.equals(AGED_BRIE) ? new AgedBrie(name) : new NotAgedBrie(name);
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    interface IsAgedBrie {

        void handleExpired();

        void updateQuality();

        void updateSellIn();
    }

    class AgedBrie implements IsAgedBrie {
        private IsBackedStagedPasses isBackedStagedPasses;

        public AgedBrie(final String name) {
            isBackedStagedPasses = new NotBackedStagedPasses("");
        }


        @Override
        public void handleExpired() {
            if (quality < MAX_QUALITY) {
                quality++;
            }
        }

        @Override
        public void updateQuality() {
            if (quality < MAX_QUALITY) {
                quality++;
                isBackedStagedPasses.increaseQuality();
            }
        }

        @Override
        public void updateSellIn() {
            isBackedStagedPasses.updateSellIn();
        }
    }

    class NotAgedBrie implements IsAgedBrie {

        private IsBackedStagedPasses isBackedStagedPasses;

        NotAgedBrie(final String name) {
            isBackedStagedPasses = name.equals(BACKSTAGE_PASSES) ? new BackedStagedPasses() : new NotBackedStagedPasses(name);
        }

        @Override
        public void handleExpired() {
            isBackedStagedPasses.handleExpired();
        }

        @Override
        public void updateQuality() {
            isBackedStagedPasses.updateQuality();
        }

        @Override
        public void updateSellIn() {
            isBackedStagedPasses.updateSellIn();
        }
    }

    interface IsBackedStagedPasses {

        void increaseQuality();

        void handleExpired();
        void updateQuality();

        void updateSellIn();
    }

    class BackedStagedPasses implements IsBackedStagedPasses {
        private IsSulfuras isSulfuras;

        BackedStagedPasses() {
            isSulfuras = new NotSulfuras();
        }

        @Override
        public void increaseQuality() {
            if (sellIn < FAR_FROM_EXPIRY) {
                if (quality < MAX_QUALITY) {
                    quality++;
                }
            }
            if (sellIn < CLOSE_TO_EXPIRY) {
                if (quality < MAX_QUALITY) {
                    quality++;
                }
            }
        }

        @Override
        public void handleExpired() {
            quality = 0; //quality - quality;
        }

        @Override
        public void updateQuality() {
            if (quality < MAX_QUALITY) {
                quality++;
                increaseQuality();
            }
        }

        @Override
        public void updateSellIn() {
            isSulfuras.updateSellIn();
        }
    }

    class NotBackedStagedPasses implements IsBackedStagedPasses {
        private IsSulfuras isSulfuras;

        NotBackedStagedPasses(String name) {
            isSulfuras = name.equals(SULFURAS) ? new Sulfuras() : new NotSulfuras();
        }

        @Override
        public void increaseQuality() {
        }

        @Override
        public void handleExpired() {
            if (quality > MIN_QUALITY) {
                isSulfuras.decreaseQuality();
            }
        }

        @Override
        public void updateQuality() {
            if (quality > MIN_QUALITY) {
                isSulfuras.decreaseQuality();
            }
        }
        @Override
        public void updateSellIn() {
            isSulfuras.updateSellIn();
        }
    }

    interface IsSulfuras {

        void decreaseQuality();

        void updateSellIn();
    }

    static class Sulfuras implements IsSulfuras {

        @Override
        public void decreaseQuality() {
        }

        @Override
        public void updateSellIn() {
        }
    }

    class NotSulfuras implements IsSulfuras {

        @Override
        public void decreaseQuality() {
            quality--;
        }

        @Override
        public void updateSellIn() {
            sellIn--;
        }
    }

    void update() {
        isAgedBrie.updateQuality();
        isAgedBrie.updateSellIn();
        if (sellIn < 0) {
            isAgedBrie.handleExpired();
        }
    }
}
