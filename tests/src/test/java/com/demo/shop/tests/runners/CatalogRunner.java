package com.demo.shop.tests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/** catalog features. */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/catalog", glue = "com.demo.shop.tests.steps", plugin = {"pretty"})
public class CatalogRunner {}
