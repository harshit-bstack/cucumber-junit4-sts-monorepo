package com.demo.shop.catalog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

/** In-memory product catalog with name/category search. */
public class Catalog {
    private final List<Product> products = new ArrayList<>(Arrays.asList(
            new Product("IP12", "iPhone 12", "phones", 79900),
            new Product("PX5", "Pixel 5", "phones", 69900),
            new Product("GS20", "Galaxy S20", "phones", 74900),
            new Product("MBA", "MacBook Air", "laptops", 99900),
            new Product("XPS", "Dell XPS 13", "laptops", 109900)));

    public Optional<Product> findBySku(String sku) {
        return products.stream().filter(p -> p.getSku().equalsIgnoreCase(sku)).findFirst();
    }

    /** Case-insensitive substring match on the product name. */
    public List<Product> searchByName(String query) {
        String q = query == null ? "" : query.trim().toLowerCase(Locale.ROOT);
        List<Product> out = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toLowerCase(Locale.ROOT).contains(q)) out.add(p);
        }
        return out;
    }

    public List<Product> byCategory(String category) {
        List<Product> out = new ArrayList<>();
        for (Product p : products) {
            if (p.getCategory().equalsIgnoreCase(category)) out.add(p);
        }
        return out;
    }
}
