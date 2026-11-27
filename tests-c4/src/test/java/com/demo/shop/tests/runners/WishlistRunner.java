package com.demo.shop.tests.runners;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/** wishlist features. */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/wishlist", glue = "com.demo.shop.tests.steps", plugin = {"pretty"})
public class WishlistRunner {}
