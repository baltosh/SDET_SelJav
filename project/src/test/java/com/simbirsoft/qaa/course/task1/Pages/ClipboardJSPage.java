package com.simbirsoft.qaa.course.task1.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

public class ClipboardJSPage {

    private WebDriver driver;

    @FindBy(xpath = "//div[@class='input-group']/input[@id='foo']")
    @CacheLookup
    WebElement textBox;

    @FindBy(xpath = "//span[@class='input-group-button']/button[@class='btn']")
    @CacheLookup
    WebElement copyButton;

    public ClipboardJSPage(WebDriver driver) {
        this.driver = driver;
    }

    public void pressCopyButton() {
        copyButton.click();
    }

    public String getValueFromTextBox() {
        return textBox.getAttribute("value");
    }
}