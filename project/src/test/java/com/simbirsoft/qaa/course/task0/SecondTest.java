package com.simbirsoft.qaa.course.task0;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class SecondTest {

    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://clipboardjs.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void copyTest() throws IOException, UnsupportedFlavorException {

        WebElement copyButton = driver.findElement(By.xpath("//span[@class='input-group-button']/button[@class='btn']"));
        copyButton.click();
        Transferable contents = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);

        String textFromButton = (String) contents.getTransferData(DataFlavor.stringFlavor);

        WebElement textBox = driver.findElement(By.xpath("//div[@class='input-group']/input[@id='foo']"));
        String textFromBox = textBox.getAttribute("value");

        Assert.assertEquals(textFromBox, textFromButton);
    }

    @AfterMethod
    public void after() {
        driver.quit();
    }
}
