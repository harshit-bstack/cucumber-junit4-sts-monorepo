package com.demo.shop.tests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/** wishlist features. */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/wishlist", glue = "com.demo.shop.tests.steps", plugin = {"pretty"})
public class WishlistRunner {}
