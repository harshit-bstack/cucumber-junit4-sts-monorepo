package com.demo.shop.tests.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/** returns features. */
@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features/returns", glue = "com.demo.shop.tests.steps", plugin = {"pretty"})
public class ReturnsRunner {}
