package testngDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;

import java.time.Duration;

public class Demo3 {
    WebDriver driver;

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.google.com/");
    }

    @Test
    public void verifyGoogleSearch() {
        String actualTitle = driver.getTitle();
        String expectedTitle = "Google"; 

        Assert.assertEquals(actualTitle, expectedTitle,"not matched");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Test Execution Completed");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("Closing browser");
            driver.quit();
        }
    }

