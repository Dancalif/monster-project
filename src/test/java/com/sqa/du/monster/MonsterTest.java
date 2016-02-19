package com.sqa.du.monster;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	public static String inputCity = "San Francisco";
	private WebDriver driver;

	@AfterClass
	public void afterClass() {
		// Quit Driver
		driver.quit();
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
		// Thread.sleep(2000);
		driver.findElement(By.linkText("Log In")).click();
		driver.findElement(By.id("EmailAddress")).sendKeys(userName);
		driver.findElement(By.id("Password")).sendKeys(userPassword);
		driver.findElement(By.xpath(".//*[@id='signInContent']/form/div[3]/input[1]")).click();

		if (driver.findElement(By.xpath("//*[@id='header']/div/div[2]/a")).isDisplayed()) {
			driver.findElement(By.xpath("//*[@id='header']/div/div[2]/a")).click();
		}

		driver.findElement(By.id("ctl00__powerSearchControl__ptbJobTitle"))
				.sendKeys(keywords[0] + ", " + keywords[1] + ", " + keywords[2]);
		driver.findElement(By.id("ctl00__powerSearchControl__ptbLocations")).sendKeys(inputCity);
		driver.findElement(By.id("ctl00__powerSearchControl__btnSearch")).click();
	}

}
