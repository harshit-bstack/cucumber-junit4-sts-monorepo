package com.demo.shop.tests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/** Catalog search, cart and checkout features (classpath root). */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/shop", glue = "com.demo.shop.tests.steps",
        plugin = {"pretty"})
public class ShopRunner {}
