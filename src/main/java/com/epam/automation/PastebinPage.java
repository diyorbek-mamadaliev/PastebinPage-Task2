package com.epam.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage {

    private final WebDriver driver;

    private final By codeFieldLocator = By.xpath("//*[@id='postform-text']");
    private final By expirationDropdownLocator = By.id("select2-postform-expiration-container");
    private final By highlightDropdownLocator = By.id("select2-postform-format-container");
    private final By nameFieldLocator = By.id("postform-name");
    private final By submitButtonLocator = By.xpath("//button[@class='btn -big']");

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
    }

    public void createNewPaste(String code, String expiration, String highlight, String name) {
        driver.get("https://pastebin.com/");

        WebElement codeField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(codeFieldLocator));
        codeField.sendKeys(code);

        WebElement expirationDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(expirationDropdownLocator));
        expirationDropdown.click();
        driver.findElement(By.xpath("//li[text()='" + expiration + "']")).click();

        WebElement highlightDropdown = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(highlightDropdownLocator));
        highlightDropdown.click();
        driver.findElement(By.xpath("//li[text()='" + highlight + "']")).click();

        WebElement nameField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(nameFieldLocator));
        nameField.sendKeys(name);

        WebElement submitButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(submitButtonLocator));
        submitButton.click();
    }
}
