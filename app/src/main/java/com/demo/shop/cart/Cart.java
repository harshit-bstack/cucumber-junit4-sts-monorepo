package com.demo.shop.cart;

import com.demo.shop.catalog.Product;

import java.util.LinkedHashMap;
import java.util.Map;

/** Shopping cart: product quantities and subtotal. */
public class Cart {
    public static final int MAX_QUANTITY_PER_ITEM = 5;

    private final Map<Product, Integer> items = new LinkedHashMap<>();

    public void add(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("quantity must be positive");
        int next = items.getOrDefault(product, 0) + quantity;
        if (next > MAX_QUANTITY_PER_ITEM) {
            throw new IllegalStateException("at most " + MAX_QUANTITY_PER_ITEM + " of " + product.getName());
        }
        items.put(product, next);
    }

    public void remove(Product product) {
        items.remove(product);
    }

    public int quantityOf(Product product) {
        return items.getOrDefault(product, 0);
    }

    public int itemCount() {
        return items.values().stream().mapToInt(Integer::intValue).sum();
    }

    public long subtotalCents() {
        long total = 0;
        for (Map.Entry<Product, Integer> e : items.entrySet()) {
            total += e.getKey().getPriceCents() * e.getValue();
        }
        return total;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
}
