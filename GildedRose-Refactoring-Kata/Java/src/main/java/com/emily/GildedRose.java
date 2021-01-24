package com.emily;

public class GildedRose {
    public Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void doUpdateQuality() {
        for (int i = 0; i < items.length; i++) {
            doUpdateQuality(items[i]);
        }
    }

    private void doUpdateQuality(final Item item) {
        switch (item.name) {
            case "Aged Brie":
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1;
                    }
                }
                break;
            case "Backstage passes to a TAFKAL80ETC concert":
                if (item.quality < 50) {
                    item.quality = item.quality + 1;

                    if (item.sellIn < 11) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < 50) {
                            item.quality = item.quality + 1;
                        }
                    }
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    item.quality = 0;
                }
                break;
            case "Sulfuras, Hand of Ragnaros":
                break;
            default:
                if (item.quality > 0) {
                    item.quality = item.quality - 1;
                }

                item.sellIn = item.sellIn - 1;

                if (item.sellIn < 0) {
                    if (item.quality > 0) {
                        item.quality = item.quality - 1;
                    }
                }
                break;
        }
    }
}
