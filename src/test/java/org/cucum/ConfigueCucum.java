package org.cucum;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigueCucum {
	WebDriver driver;
	@Given("User should hit the url of facebook application in Gc browser")
	public void user_should_hit_the_url_of_facebook_application_in_Gc_browser() {
	   WebDriverManager.chromedriver().setup();
	   driver=new ChromeDriver();
	   driver.get("https://en-gb.facebook.com/");
	   driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
	   
	}

//	@When("User should enter username and password")
//	public void user_should_enter_username_and_password() {
//	    driver.findElement(By.id("email")).sendKeys("Aravinth1895");
//	    driver.findElement(By.id("pass")).sendKeys("123243546");
	@When("User should enter {string} and {string}")
	public void user_should_enter_and(String user,String pass) {
		  driver.findElement(By.id("email")).sendKeys(user);
	    driver.findElement(By.id("pass")).sendKeys(pass);
		
}
	@When("User should click create new account button")
	public void user_should_click_create_new_account_button() {
	   driver.findElement(By.xpath("//a[text()='Create New Account']")).click();
	}

	@When("User should click the male button")
	public void user_should_click_the_male_button() {
	    driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
	}
	
	@When("User should click login button")
	public void user_should_click_login_button() {
	    driver.findElement(By.name("login")).click();
	}

    @Then("User should quit the browser")
	public void user_should_quit_the_browser() {
	   driver.quit();

	}
	

}
