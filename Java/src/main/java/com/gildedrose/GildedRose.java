package com.gildedrose;

import java.util.List;

// Mi servicio de Spring Boot
class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            item.setItemName(ItemName.calculaItemNameEnFuncionDeDescripcion(item.name));

            item.quality = calculaCalidadDelItem(item);
        }
    }


    private static int calculaCalidadDelItem(Item item) {
        int quality = item.quality;
        if(ItemName.OTHER.equals(item.getItemName())) {
            if (quality > 0) {
                quality = quality - 1;
            }
        } else {
            if (quality < 50) {
                quality = quality + 1;

                if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                    if (quality < 50 && item.sellIn < 6) {
                        quality = quality + 1;
                    }

                }
            }
        }

        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }

        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                    if (quality > 0 && !item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                        quality = quality - 1;
                    }
                } else {
                    quality = 0;
                }
            } else {
                if (quality < 50) {
                    quality = quality + 1;
                }
            }
        }
        return quality;
    }
}
