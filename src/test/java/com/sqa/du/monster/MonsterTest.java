package com.sqa.du.monster;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MonsterTest {

	public static String baseURL = "http://monster.com";
	public static String[] keywords = { "Java", "Automation", "Selenium" };
	public static String userName = "dancalif@gmail.com";
	public static String userPassword = "testtest123";
	public static WebElement element;
	private WebDriver driver;

	@AfterClass
	public void afterClass() {
		// Quit Driver
		// driver.quit();
	}

	@BeforeClass
	public void beforeClass() {
		// System.setProperty("webdriverchrome.chrome.driver",
		// "chromedriver.exe");
		// this.driver = new ChromeDriver();
		driver = new FirefoxDriver();
		driver.get(baseURL + "/");
	}

	@DataProvider(name = "test1")
	public Object[][] dp1() {
		return new Object[][] { { "Test 1", keywords, 10, 5 } };
	}

	@Test(dataProvider = "test1")
	public void test1(String testName, String[] keywords, int maxResultsNum, int requiredResultsNum)
			throws InterruptedException {
		Thread.sleep(2000);
		element = driver.findElement(By.id("loginLink"));
		if (element.isDisplayed()) {
			element.click();
		} else {
			System.out.println("Couldn't find your f...ing element!!!");
		}

		// By.id("loginLink")).isDisplayed());
		// driver.findElement(By.id("EmailAddress")).sendKeys(userName);
		// driver.findElement(By.id("Password")).sendKeys(userPassword);
		// driver.findElement(By.xpath(".//*[@id='signInContent']/form/div[3]/input[1]")).click();
	}

}
