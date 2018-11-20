package com.simbirsoft.qaa.course.task1.Tests;

import com.simbirsoft.qaa.course.task1.Pages.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SearchWithGoogle {

    private static WebDriver driver;
    private static GoogleSearchPage googleSearchPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);

    }

    @Test
    @Parameters("query")
    public void searchTest(@Optional("Параметр не задан") String query) {

        googleSearchPage.putTextIntoSearchBox(query);
        googleSearchPage.pressSearchButton();

        Assert.assertTrue(googleSearchPage.numberOfResults() > 0, "Не найдено");
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
