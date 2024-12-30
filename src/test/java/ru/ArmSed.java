package ru;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArmSed {
    WebDriver driver;
    WebDriverWait wait;
    WebElement element;
    @BeforeMethod
            (alwaysRun = true)
    public void setUpDriver(){
        ChromeOptions options = new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }
    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.get("http://rrmsfm-wfc002lk.test.vtb.ru:8080/mbot/?noredirect");
    }
    @Test
    public void armsed(){
        wait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        driver.findElement(By.xpath("//button[@id=\"button_pusk\"]")).sendKeys(Keys.ENTER);
    }
    @After
    public void tearDown(){driver.quit();}
}
