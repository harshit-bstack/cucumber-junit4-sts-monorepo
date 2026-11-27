package com.demo.shop.tests.steps;

import com.demo.shop.cart.Cart;
import com.demo.shop.catalog.Catalog;
import com.demo.shop.catalog.Product;
import com.demo.shop.checkout.CheckoutService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ShopSteps {
    private final Catalog catalog = new Catalog();
    private final Cart cart = new Cart();
    private final CheckoutService checkout = new CheckoutService();
    private List<Product> results;
    private CheckoutService.Order order;
    private RuntimeException error;

    private Product product(String sku) {
        return catalog.findBySku(sku).orElseThrow(() -> new AssertionError("no product " + sku));
    }

    @When("I search for {string}")
    public void search(String query) {
        results = catalog.searchByName(query);
    }

    @When("I browse the {string} category")
    public void browse(String category) {
        results = catalog.byCategory(category);
    }

    @Then("I see {int} product(s)")
    public void seeProducts(int count) {
        assertEquals(count, results.size());
    }

    @Given("my cart contains {int} x {string}")
    @When("I add {int} x {string} to my cart")
    public void add(int qty, String sku) {
        try {
            cart.add(product(sku), qty);
        } catch (RuntimeException e) {
            error = e;
        }
    }

    @When("I remove {string} from my cart")
    public void remove(String sku) {
        cart.remove(product(sku));
    }

    @Then("my cart has {int} item(s)")
    public void itemCount(int count) {
        assertEquals(count, cart.itemCount());
    }

    @Then("my cart subtotal is {long} cents")
    public void subtotal(long cents) {
        assertEquals(cents, cart.subtotalCents());
    }

    @Then("adding more is rejected")
    public void rejected() {
        assertNotNull(error);
    }

    @When("I check out to {string}")
    public void checkOut(String address) {
        try {
            order = checkout.checkout(cart, address);
        } catch (RuntimeException e) {
            error = e;
        }
    }

    @Then("the order total is {long} cents")
    public void orderTotal(long cents) {
        assertEquals(cents, order.getTotalCents());
    }

    @Then("shipping is free")
    public void freeShipping() {
        assertEquals(0, order.getShippingCents());
    }

    @Then("checkout fails")
    public void checkoutFails() {
        assertNotNull(error);
        assertTrue(cart.isEmpty() || order == null);
    }
}
