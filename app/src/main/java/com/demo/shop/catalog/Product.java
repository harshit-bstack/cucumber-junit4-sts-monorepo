package com.demo.shop.catalog;

/** A product in the catalog. Prices are in cents. */
public final class Product {
    private final String sku;
    private final String name;
    private final String category;
    private final long priceCents;

    public Product(String sku, String name, String category, long priceCents) {
        this.sku = sku;
        this.name = name;
        this.category = category;
        this.priceCents = priceCents;
    }

    public String getSku() { return sku; }
    public String getName() { return name; }
    public String getCategory() { return category; }
    public long getPriceCents() { return priceCents; }
}
