package com.web.automation;

import static org.junit.Assert.*;

//
import java.util.List;

import org.junit.After;
//import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Unit test for simple App
 */
public class GskHomePageTest {
	
	private WebDriver driver;
	public WebDriverWait wait;
	private static final String URL = "https://www.gsk.com";
	private static final String URL_cbt = "https://www.cbtalentdriver.com";
	
	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "src/test/resource/geckodriver.exe");
		driver = new FirefoxDriver();
		wait= new WebDriverWait(driver, 20);
	}
	
	@Test
	public void test_gsk_homepage() {
		driver.get(URL);
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/main/div[1]/div[2]/div/h2/a"))).getText();
		assertTrue(text.contains("How do consumer insights fuel our innovation?"));	
	}
	
	//@Test
	public void test_career() {
		driver.get(URL_cbt);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Media Campaigns"))).click();
		//driver.findElement(By.linkText("Media Campaigns")).click();
		String text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header-info']/h1"))).getText();
		assertEquals(text, "Media Campaigns");//
	
		
	}
	
	@After
	public void tearDown() {
			driver.quit();
		}
	
}
