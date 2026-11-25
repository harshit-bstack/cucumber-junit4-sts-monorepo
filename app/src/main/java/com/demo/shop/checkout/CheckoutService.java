package com.demo.shop.checkout;

import com.demo.shop.cart.Cart;

/** Turns a cart into an order total: subtotal + shipping + tax. */
public class CheckoutService {
    public static final long FREE_SHIPPING_THRESHOLD_CENTS = 100000;
    public static final long SHIPPING_CENTS = 999;
    public static final double TAX_RATE = 0.08;

    public Order checkout(Cart cart, String shippingAddress) {
        if (cart.isEmpty()) throw new IllegalStateException("cart is empty");
        if (shippingAddress == null || shippingAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("shipping address is required");
        }
        long subtotal = cart.subtotalCents();
        long shipping = subtotal >= FREE_SHIPPING_THRESHOLD_CENTS ? 0 : SHIPPING_CENTS;
        long tax = Math.round(subtotal * TAX_RATE);
        Order order = new Order(subtotal, shipping, tax);
        cart.clear();
        return order;
    }

    public static final class Order {
        private final long subtotalCents;
        private final long shippingCents;
        private final long taxCents;

        Order(long subtotalCents, long shippingCents, long taxCents) {
            this.subtotalCents = subtotalCents;
            this.shippingCents = shippingCents;
            this.taxCents = taxCents;
        }

        public long getSubtotalCents() { return subtotalCents; }
        public long getShippingCents() { return shippingCents; }
        public long getTaxCents() { return taxCents; }
        public long getTotalCents() { return subtotalCents + shippingCents + taxCents; }
    }
}
