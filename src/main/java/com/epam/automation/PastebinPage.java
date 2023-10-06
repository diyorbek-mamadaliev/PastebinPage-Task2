package com.epam.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PastebinPage {

    private final WebDriver driver;

    private final By codeFieldLocator = By.id("postform-text");
    private final By expirationDropdownLocator = By.id("select2-postform-expiration-container");
    private final By highlightDropdownLocator = By.id("select2-postform-format-container");
    private final By nameFieldLocator = By.id("postform-name");
    private final By submitButtonLocator = By.xpath("//button[@class='btn -big']");

    // Reusable WebDriverWait with a default timeout of 10 seconds
    private final WebDriverWait wait;

    public PastebinPage(WebDriver driver) {
        this.driver = driver;
        // Initialize the webdriver wait
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void createNewPaste(String code, String expiration, String highlight, String name) {
        driver.get("https://pastebin.com/");

        WebElement codeField = waitForVisibilityOfElement(codeFieldLocator);
        codeField.sendKeys(code);

        WebElement expirationDropdown = waitForElementToBeClickable(expirationDropdownLocator);
        expirationDropdown.click();
        driver.findElement(By.xpath("//li[text()='" + expiration + "']")).click();

        WebElement highlightDropdown = waitForElementToBeClickable(highlightDropdownLocator);
        highlightDropdown.click();
        driver.findElement(By.xpath("//li[text()='" + highlight + "']")).click();

        WebElement nameField = waitForVisibilityOfElement(nameFieldLocator);
        nameField.sendKeys(name);

        WebElement submitButton = waitForElementToBeClickable(submitButtonLocator);
        submitButton.click();
    }

    // wait for element visibility
    private WebElement waitForVisibilityOfElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // wait for element to be clickable
    private WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
