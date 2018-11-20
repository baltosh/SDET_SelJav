package com.simbirsoft.qaa.course.task1.Tests;

import com.simbirsoft.qaa.course.task1.ClipboardHelper;
import com.simbirsoft.qaa.course.task1.Pages.GoogleSearchPage;
import com.simbirsoft.qaa.course.task1.QueryLib;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PastingFromClipBoard {

    private static WebDriver driver;
    private static ClipboardHelper clipboardHelper;
    private static GoogleSearchPage googleSearchPage;
    private static QueryLib queryLib;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);

        clipboardHelper = new ClipboardHelper();

        queryLib = new QueryLib();
    }

    @Test
    public void searchTest() {

        String searchQuery = queryLib.getQueryText(1);
        clipboardHelper.putTextIntoClipboard(searchQuery);

        googleSearchPage.pasteIntoSearchBox();

        Assert.assertEquals(googleSearchPage.getValueFromSearchBox(), searchQuery);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
