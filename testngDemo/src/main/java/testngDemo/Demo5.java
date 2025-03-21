package testngDemo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Demo5 {
	public class DemoTest {
	    WebDriver driver;

	    @BeforeClass
	    public void setUp() {
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://tutorialsninja.com/demo/");
	    }

	    @Test
	    public void testNavigation() {
	        driver.findElement(By.xpath("//span[text()='My Account']")).click();
	        driver.findElement(By.xpath("//a[text()='Register']")).click();

	        String expectedTitle = "Register"; 
	        String actualTitle = driver.getTitle();
//	        Assert.assertEquals(actualTitle, expectedTitle, "Title does not match");
	        SoftAssert softassert=new SoftAssert();
	        softassert.assertEquals(actualTitle, expectedTitle, "Title does not match");

	        driver.findElement(By.xpath("//a[text()='Qafox.com']")).click();
//	        Assert.assertEquals(driver.getTitle(), "Your Store"); 
	        softassert.assertEquals(driver.getTitle(), "Your Stor");
	        softassert.assertAll();
	    }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }
	}
}
