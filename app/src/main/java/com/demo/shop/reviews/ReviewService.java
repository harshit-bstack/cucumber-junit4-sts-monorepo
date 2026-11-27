package com.demo.shop.reviews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** Star ratings (1-5) per product SKU. */
public class ReviewService {
    private final Map<String, List<Integer>> ratings = new HashMap<>();

    public void review(String sku, int stars) {
        if (stars < 1 || stars > 5) throw new IllegalArgumentException("stars must be 1-5");
        ratings.computeIfAbsent(sku, k -> new ArrayList<>()).add(stars);
    }

    public int count(String sku) {
        return ratings.getOrDefault(sku, new ArrayList<>()).size();
    }

    public double average(String sku) {
        List<Integer> r = ratings.getOrDefault(sku, new ArrayList<>());
        if (r.isEmpty()) return 0;
        return r.stream().mapToInt(Integer::intValue).average().orElse(0);
    }
}
