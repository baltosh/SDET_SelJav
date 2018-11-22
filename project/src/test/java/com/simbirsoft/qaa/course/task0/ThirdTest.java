package com.simbirsoft.qaa.course.task0;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.util.concurrent.TimeUnit;

public class ThirdTest {

    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void pasteTest() {

        WebElement searchInputElement = driver.findElement(By.id("lst-ib"));

        String searchQuery = "Sad Pablo Escobar";
        StringSelection content = new StringSelection(searchQuery);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(content, null);

        searchInputElement.sendKeys(Keys.CONTROL + "v");

        String textFromSIE = searchInputElement.getAttribute("value");

        Assert.assertEquals(searchQuery, textFromSIE);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
