package com.demo.shop.returns;

import com.demo.shop.cart.Cart;
import com.demo.shop.catalog.Product;

/** Return requests: refundable within 30 days of delivery. */
public class ReturnService {
    public static final int RETURN_WINDOW_DAYS = 30;

    public Result request(Product product, int quantity, int daysSinceDelivery) {
        if (daysSinceDelivery > RETURN_WINDOW_DAYS) return new Result(Status.REJECTED, 0);
        long refund = product.getPriceCents() * quantity;
        // Refund what was actually paid: bulk-discounted lines are refunded at the discounted price.
        if (quantity >= Cart.BULK_DISCOUNT_MIN_QUANTITY) {
            refund -= Math.round(refund * Cart.BULK_DISCOUNT_RATE);
        }
        return new Result(Status.APPROVED, refund);
    }

    public enum Status { APPROVED, REJECTED }

    public static final class Result {
        private final Status status;
        private final long refundCents;

        Result(Status status, long refundCents) {
            this.status = status;
            this.refundCents = refundCents;
        }

        public Status getStatus() { return status; }
        public long getRefundCents() { return refundCents; }
    }
}
