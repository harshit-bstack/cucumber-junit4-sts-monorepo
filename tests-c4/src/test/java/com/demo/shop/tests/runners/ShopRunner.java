package com.demo.shop.tests.runners;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/** Catalog search, cart and checkout features (classpath root). */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/shop", glue = "com.demo.shop.tests.steps",
        plugin = {"pretty"})
public class ShopRunner {}
