package com.simbirsoft.qaa.course.task1.Tests;

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

import static com.simbirsoft.qaa.course.task1.Helpers.ClipboardHelper.getTextFromClipboard;

public class CopyingIntoClipBoardWithButton {

    private static WebDriver driver;
    private static ClipboardJSPage clipboardJSPage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://clipboardjs.com");

        clipboardJSPage = PageFactory.initElements(driver, ClipboardJSPage.class);
    }

    @Test
    public void copyingIntoClipboardTest() throws IOException, UnsupportedFlavorException {
        String textFromBox = clipboardJSPage.getValueFromTextBox();

        clipboardJSPage.pressCopyButton();
        String textFromButton = getTextFromClipboard();

        Assert.assertEquals(textFromBox, textFromButton);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
