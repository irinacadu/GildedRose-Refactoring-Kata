package com.gildedrose;

import java.util.Arrays;

public enum ItemName {
    AGED_BRIE("Aged Brie"),
    BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT("Backstage passes to a TAFKAL80ETC concert"),
    SULFURAS_HAND_OF_RAGNAROS("Sulfuras, Hand of Ragnaros"),
    OTHER("Any Other");

    public final String descripcion;

    ItemName(String descripcion) {
        this.descripcion = descripcion;
    }

    public static ItemName calculaItemNameEnFuncionDeDescripcion(String descripcion) {
        return Arrays.stream(values()).filter(value -> value.descripcion.equals(descripcion)).findFirst().orElse(OTHER);
    }

}
