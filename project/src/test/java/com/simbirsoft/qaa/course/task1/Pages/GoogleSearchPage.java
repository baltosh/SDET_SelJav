package com.simbirsoft.qaa.course.task1.Pages;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;


import java.util.List;

public class GoogleSearchPage {

    private WebDriver driver;

    @FindBy(name = "q")
    @CacheLookup
    WebElement searchBox;

    @FindBy(name = "btnK")
    @CacheLookup
    WebElement searchButton;

    @FindBy(css = "div#search div[data-hveid]")
    @CacheLookup
    List<WebElement> searchResultsElements;

    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
    }

    public void putTextIntoSearchBox(String text) {
        searchBox.sendKeys(text);
    }

    public void pasteIntoSearchBox() {
        searchBox.sendKeys(Keys.CONTROL + "v");
    }

    public String getValueFromSearchBox() {
        return searchBox.getAttribute("value");
    }

    public void pressSearchButton() {
        searchButton.click();
    }

    public int numberOfResults() {
        return searchResultsElements.size();
    }
}