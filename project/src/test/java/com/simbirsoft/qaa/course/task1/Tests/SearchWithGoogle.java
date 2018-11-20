package com.simbirsoft.qaa.course.task1.Tests;

import com.simbirsoft.qaa.course.task1.Pages.GoogleSearchPage;
import com.simbirsoft.qaa.course.task1.QueryLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchWithGoogle {

    private static WebDriver driver;
    private static GoogleSearchPage googleSearchPage;
    private static QueryLib queryLib;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);

        queryLib = new QueryLib();
    }

    @Test
    public void searchTest() {

        googleSearchPage.putTextIntoSearchBox(queryLib.getQueryText(0));
        googleSearchPage.pressSearchButton();

        Assert.assertTrue(googleSearchPage.numberOfResults() > 0, "Не найдено");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
