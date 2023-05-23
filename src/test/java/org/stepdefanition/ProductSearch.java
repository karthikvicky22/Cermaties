package org.stepdefanition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductSearch {

	WebDriver driver;

	@Given("user launch ebay application")
	public void user_launch_ebay_application() {

		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.ebay.com/");
		driver.manage().window().maximize();

	}

	@When("user enter the product to search {string}")
	public void user_enter_the_product_to_search(String value) {

		WebElement entrstring = driver.findElement(By.xpath("//input[@type='text']"));
		entrstring.sendKeys(value);

	}

	@When("user click search button")
	public void user_click_search_button() throws InterruptedException {
		WebElement clicksrch = driver.findElement(By.xpath("//input[@type='submit']"));
		clicksrch.click();
		Thread.sleep(2000);

	}

	@When("user choose the search category")
	public void user_choose_the_search_category() {
		WebElement clickcatogry = driver.findElement(By.xpath("(//select[@class='gh-sb '])[1]"));
		clickcatogry.click();
		WebElement option = driver.findElement(By.id("gh-cat"));

		Select s = new Select(option);
		s.selectByVisibleText("Computers/Tablets & Networking");

		WebElement clicksubmit = driver.findElement(By.xpath("(//input[@type='submit'])[1]"));
		clicksubmit.click();

	}

	@Then("user see the products based on the search")
	public void user_see_the_products_based_on_the_search() {
		WebElement item = driver.findElement(By
				.xpath("//*[text()='ULTRALIGHT Apple MacBook Air 13\" i7  - 2017-2019 Model - 512GB SSD - WARRANTY']"));
	Assert.assertTrue(item.getText().contains("Mac"));
	
	}

}
