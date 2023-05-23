package org.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\featureFiles\\ProductSearch.feature",
glue="org.stepdefanition",monochrome = true ,dryRun =false)




public class RunnerClass {

}
