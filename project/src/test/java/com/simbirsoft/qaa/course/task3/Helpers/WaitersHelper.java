package com.simbirsoft.qaa.course.task3.Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitersHelper {

    public static int defaultWaitTime = 10;

    public static WebElement useWhenClickable(WebDriver driver, WebElement element) {
        return (new WebDriverWait(driver, defaultWaitTime)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement useWhenVisible(WebDriver driver, WebElement element) {
        return (new WebDriverWait(driver, defaultWaitTime)).until(ExpectedConditions.visibilityOf(element));
    }
}
