package com.demo.shop.wishlist;

import com.demo.shop.catalog.Product;

import java.util.LinkedHashSet;
import java.util.Set;

/** A shopper's wishlist: a set of products (duplicates ignored). */
public class Wishlist {
    private final Set<Product> items = new LinkedHashSet<>();

    public void add(Product product) {
        items.add(product);
    }

    public void remove(Product product) {
        items.remove(product);
    }

    public boolean contains(Product product) {
        return items.contains(product);
    }

    public int size() {
        return items.size();
    }
}
