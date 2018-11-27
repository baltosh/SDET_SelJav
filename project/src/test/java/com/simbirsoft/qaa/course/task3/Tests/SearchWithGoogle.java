package com.simbirsoft.qaa.course.task3.Tests;

import com.simbirsoft.qaa.course.task3.Pages.ClipboardJSPage;
import com.simbirsoft.qaa.course.task3.Helpers.TLDriverFactory;
import com.simbirsoft.qaa.course.task3.Pages.GoogleSearchPage;
import org.testng.Assert;
import org.testng.annotations.*;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import static com.simbirsoft.qaa.course.task3.Helpers.ClipboardHelper.getTextFromClipboard;

public class SearchWithGoogle {

    @BeforeMethod
    public void beforeMethod() {
        TLDriverFactory.setTLDriver("chrome");
    }


    @Test
    @Parameters("query")
    public void searchTest(@Optional("Параметр не задан") String query) {

        TLDriverFactory.getTLDriver().get("http://www.google.com");
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(TLDriverFactory.getTLDriver())
                .putTextIntoSearchBox(query)
                .pressSearchButton();

        Assert.assertTrue(googleSearchPage.getNumberOfResults() > 0, "Не найдено");
    }


    @Test
    public void copyingIntoClipboardTest() throws IOException, UnsupportedFlavorException {

        TLDriverFactory.getTLDriver().get("https://clipboardjs.com");
        ClipboardJSPage clipboardJSPage = new ClipboardJSPage(TLDriverFactory.getTLDriver());
        String textFromBox = clipboardJSPage.getValueFromTextBox();

        clipboardJSPage
                .pressCopyButton();

        Assert.assertEquals(textFromBox, getTextFromClipboard());
    }



    @AfterMethod
    public void after() {
        TLDriverFactory.getTLDriver().quit();
    }
}
