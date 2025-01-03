package ru;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.junit.Assert;
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

import static org.testng.Assert.assertEquals;

public class ArmSedTest {
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
        //driver.get("http://rrmsfm-wfc002lk.test.vtb.ru:8080/mbot/?noredirect");
        driver.get("https://www.flypobeda.ru/");
    }
    @Test
    public void armsed1(){
       // wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        //driver.findElement(By.xpath("//button[@id=\"button_pusk\"]")).sendKeys(Keys.ENTER);
        assertEquals(driver.getCurrentUrl(),"https://www.flypobeda.ru/");
        assertEquals(driver.getTitle(),"Авиакомпания «Победа» - купить авиабилеты онлайн, дешёвые билеты на самолёт, прямые и трансферные рейсы с пересадками");

    }
    @Test
    public void armsed2(){
        // wait = new WebDriverWait(driver, Duration.ofSeconds(20L));
        //driver.findElement(By.xpath("//button[@id=\"button_pusk\"]")).sendKeys(Keys.ENTER);
        driver.findElement(By.xpath("//img[contains(@alt,\"«Авиакомпания «Победа», Группа «Аэрофлот»\")]")).click();
    }
    @After
    public void tearDown(){driver.quit();}
    @Step("Verify url is: {url}")
    public void checkUrl(String url){
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("url совпадает", currentUrl,url);
    }
    @Step("Verify title is: {title}")
        public void checkTitle(String title){
            String currentTitle = driver.getTitle();
            Assert.assertEquals("Title совпадает ", currentTitle, title);
        }
}
