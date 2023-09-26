package com.epam.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage {

    private final WebDriver driver;

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewPaste(String code, String expiration, String name) {
        // navigate to the "New Paste" page
        driver.get("https://pastebin.com/");

        // enter the code
        WebElement codeField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='postform-text']")));
        codeField.sendKeys(code);

        // select the expiration
        WebElement expirationDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.id("select2-postform-expiration-container")));
        expirationDropdown.click();
        driver.findElement(By.xpath("//li[text()='" + expiration + "']")).click();

        // enter the name
        WebElement nameField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("postform-name")));
        nameField.sendKeys(name);

        // click and submit the paste
        WebElement submitButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='w0']/div[5]/div[1]/div[10]/button")));
        submitButton.click();
    }
}
