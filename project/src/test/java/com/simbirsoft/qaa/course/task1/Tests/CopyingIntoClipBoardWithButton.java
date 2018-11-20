package com.simbirsoft.qaa.course.task1.Tests;

import com.simbirsoft.qaa.course.task1.ClipboardHelper;
import com.simbirsoft.qaa.course.task1.Pages.ClipboardJSPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CopyingIntoClipBoardWithButton {

    private static WebDriver driver;
    private static ClipboardHelper clipboardHelper;
    private static ClipboardJSPage clipboardJSPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://clipboardjs.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        clipboardHelper = new ClipboardHelper();

    }

    @Test
    public void searchTest() throws IOException, UnsupportedFlavorException {

        clipboardJSPage = PageFactory.initElements(driver, ClipboardJSPage.class);

        String textFromBox = clipboardJSPage.getValueFromTextBox();

        clipboardJSPage.pressCopyButton();
        String textFromButton = clipboardHelper.getTextFromClipboard();

        Assert.assertEquals(textFromBox, textFromButton);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
