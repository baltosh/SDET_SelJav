package com.simbirsoft.qaa.course.task3.Pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static com.simbirsoft.qaa.course.task1.Helpers.WaitersHelper.*;

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
        PageFactory.initElements(driver, this);
    }

    public GoogleSearchPage putTextIntoSearchBox(String text) {

        useWhenClickable(driver, searchBox).sendKeys(text);
        return new GoogleSearchPage(driver);
    }

    public GoogleSearchPage pasteIntoSearchBox() {

        useWhenClickable(driver, searchBox).sendKeys(Keys.CONTROL + "v");
        return new GoogleSearchPage(driver);
    }

    public GoogleSearchPage pressSearchButton() {

        useWhenClickable(driver, searchButton).click();
        return new GoogleSearchPage(driver);
    }

    public String getValueFromSearchBox() {
        return useWhenVisible(driver, searchBox).getAttribute("value");
    }

    public int getNumberOfResults() {
        new WebDriverWait(driver, defaultWaitTime).until(ExpectedConditions.visibilityOf(searchResultsElements.get(0)));
        return searchResultsElements.size();
    }
}