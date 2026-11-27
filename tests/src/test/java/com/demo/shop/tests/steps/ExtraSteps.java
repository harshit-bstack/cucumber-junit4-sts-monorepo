package com.demo.shop.tests.steps;

import com.demo.shop.catalog.Catalog;
import com.demo.shop.catalog.Product;
import com.demo.shop.returns.ReturnService;
import com.demo.shop.reviews.ReviewService;
import com.demo.shop.wishlist.Wishlist;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/** Wishlist, returns and reviews steps. */
public class ExtraSteps {
    private final Catalog catalog = new Catalog();
    private final Wishlist wishlist = new Wishlist();
    private final ReturnService returns = new ReturnService();
    private final ReviewService reviews = new ReviewService();
    private ReturnService.Result returnResult;
    private Product deliveredProduct;
    private int deliveredQty;
    private int deliveredDaysAgo;
    private RuntimeException error;

    private Product product(String sku) {
        return catalog.findBySku(sku).orElseThrow(() -> new AssertionError("no product " + sku));
    }

    // --- wishlist ---
    @Given("my wishlist is empty")
    public void emptyWishlist() {
        assertEquals(0, wishlist.size());
    }

    @When("I add {string} to my wishlist")
    public void addWish(String sku) {
        wishlist.add(product(sku));
    }

    @When("I remove {string} from my wishlist")
    public void removeWish(String sku) {
        wishlist.remove(product(sku));
    }

    @Then("my wishlist has {int} item(s)")
    public void wishCount(int count) {
        assertEquals(count, wishlist.size());
    }

    @Then("my wishlist contains {string}")
    public void wishContains(String sku) {
        assertTrue(wishlist.contains(product(sku)));
    }

    @Then("my wishlist does not contain {string}")
    public void wishNotContains(String sku) {
        assertFalse(wishlist.contains(product(sku)));
    }

    // --- returns ---
    @Given("an order of {int} x {string} was delivered {int} days ago")
    public void delivered(int qty, String sku, int days) {
        deliveredProduct = product(sku);
        deliveredQty = qty;
        deliveredDaysAgo = days;
    }

    @When("I request a return")
    public void requestReturn() {
        returnResult = returns.request(deliveredProduct, deliveredQty, deliveredDaysAgo);
    }

    @Then("the return is {string}")
    public void returnStatus(String status) {
        assertEquals(ReturnService.Status.valueOf(status), returnResult.getStatus());
    }

    @Then("the refund is {long} cents")
    public void refund(long cents) {
        assertEquals(cents, returnResult.getRefundCents());
    }

    // --- reviews ---
    @When("I review {string} with {int} stars")
    public void review(String sku, int stars) {
        try {
            reviews.review(sku, stars);
        } catch (RuntimeException e) {
            error = e;
        }
    }

    @Then("{string} has {int} review(s)")
    public void reviewCount(String sku, int count) {
        assertEquals(count, reviews.count(sku));
    }

    @Then("the average rating of {string} is {double}")
    public void average(String sku, double avg) {
        assertEquals(avg, reviews.average(sku), 0.001);
    }

    @Then("the review is rejected")
    public void reviewRejected() {
        assertNotNull(error);
    }
}
