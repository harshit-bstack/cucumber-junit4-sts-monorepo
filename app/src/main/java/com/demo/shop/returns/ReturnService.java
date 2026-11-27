package com.demo.shop.returns;

import com.demo.shop.catalog.Product;

/** Return requests: refundable within 30 days of delivery. */
public class ReturnService {
    public static final int RETURN_WINDOW_DAYS = 30;

    public Result request(Product product, int quantity, int daysSinceDelivery) {
        if (daysSinceDelivery > RETURN_WINDOW_DAYS) return new Result(Status.REJECTED, 0);
        return new Result(Status.APPROVED, product.getPriceCents() * quantity);
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
