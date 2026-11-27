package com.demo.shop.tests.runners;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

/** Single runner covering every feature (run with -Dtest=SingleSuite; not picked up by the default *Runner include). */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features", glue = "com.demo.shop.tests.steps", plugin = {"pretty"})
public class SingleSuite {}
