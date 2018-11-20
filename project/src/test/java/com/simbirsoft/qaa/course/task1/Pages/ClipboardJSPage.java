package com.simbirsoft.qaa.course.task1.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.simbirsoft.qaa.course.task1.Helpers.WaitersHelper.useWhenClickable;

public class ClipboardJSPage {

    public WebDriver driver;

    @FindBy(css = ".input-group #foo")
    @CacheLookup
    WebElement textBox;

    @FindBy(css = ".input-group-button .btn")
    @CacheLookup
    WebElement copyButton;

    public ClipboardJSPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressCopyButton() {
        useWhenClickable(driver, copyButton).click();
    }

    public String getValueFromTextBox() {
        return useWhenClickable(driver, textBox).getAttribute("value");
    }
}