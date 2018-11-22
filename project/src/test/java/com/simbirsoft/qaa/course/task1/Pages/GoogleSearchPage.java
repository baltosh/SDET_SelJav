package com.simbirsoft.qaa.course.task1.Pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.simbirsoft.qaa.course.task1.Helpers.WaitersHelper.defaultWaitTime;
import static com.simbirsoft.qaa.course.task1.Helpers.WaitersHelper.useWhenClickable;
import static com.simbirsoft.qaa.course.task1.Helpers.WaitersHelper.useWhenVisible;

public class GoogleSearchPage {

    public WebDriver driver;

    @FindBy(css = "[type = 'text']")
    @CacheLookup
    WebElement searchBox;

    @FindBy(css = "[type = 'submit']")
    @CacheLookup
    WebElement searchButton;

    @FindBy(css = "#search div[data-hveid]")
    @CacheLookup
    List<WebElement> searchResultsElements;

    public GoogleSearchPage(WebDriver driver) {

        this.driver = driver;
    }

    public void putTextIntoSearchBox(String text) {

        useWhenClickable(driver, searchBox).sendKeys(text);
    }

    public void pasteIntoSearchBox() {
        useWhenClickable(driver, searchBox).sendKeys(Keys.CONTROL + "v");
    }

    public String getValueFromSearchBox() {
        return useWhenVisible(driver, searchBox).getAttribute("value");
    }

    public void pressSearchButton() {

        useWhenClickable(driver, searchButton).click();
    }

    public int numberOfResults() {
        new WebDriverWait(driver, defaultWaitTime).until(ExpectedConditions.visibilityOf(searchResultsElements.get(0)));
        return searchResultsElements.size();
    }
}