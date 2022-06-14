package org.cum1;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src\\test\\resources\\Feature",glue="org.cucum",dryRun=false,monochrome=true)
public class Facebook {   
	
}
