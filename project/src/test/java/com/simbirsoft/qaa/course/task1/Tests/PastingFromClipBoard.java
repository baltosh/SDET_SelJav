package com.simbirsoft.qaa.course.task1.Tests;

import com.simbirsoft.qaa.course.task1.Pages.GoogleSearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.simbirsoft.qaa.course.task1.Helpers.ClipboardHelper.putTextIntoClipboard;

public class PastingFromClipBoard {

    private static WebDriver driver;
    private static GoogleSearchPage googleSearchPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("http://www.google.com");

        googleSearchPage = PageFactory.initElements(driver, GoogleSearchPage.class);
    }

    @Test(dataProvider = "dp")
    public void pastingIntoClipBoardTest(String searchQuery) {

        putTextIntoClipboard(searchQuery);

        googleSearchPage.pasteIntoSearchBox();

        Assert.assertEquals(googleSearchPage.getValueFromSearchBox(), searchQuery);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }

    @DataProvider
    public Object[][] dp() {
        return new Object[][]{
                new Object[]{"Sad Pablo Escobar"},
                new Object[]{"Happy Pablo Escobar"},
        };
    }
}
