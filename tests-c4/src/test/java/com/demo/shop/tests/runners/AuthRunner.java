package com.demo.shop.tests.runners;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/** Login / logout features (filesystem path root). */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/auth", glue = "com.demo.shop.tests.steps",
        plugin = {"pretty"})
public class AuthRunner {}
