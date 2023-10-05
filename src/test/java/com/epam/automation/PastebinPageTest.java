package com.epam.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class PastebinPageTest {
    private WebDriver driver;
    private PastebinPage pastebinPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        pastebinPage = new PastebinPage(driver);
    }

    @Test
    public void testCreateNewPaste() {
        String code = """
                git config --global user.name  "New Sheriff in Town"
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                git push origin master --force""";
        String expiration = "10 Minutes";
        String highlight = "Bash";
        String name = "how to gain dominance among developers";

        pastebinPage.createNewPaste(code, expiration, highlight, name);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Assertion 1:
        WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='how to gain dominance among developers']")));
        Assert.assertTrue(titleElement.isDisplayed(), "Page title does not match.");

        // Assertion 2:
        WebElement syntaxHighlightingElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Bash']")));
        Assert.assertTrue(syntaxHighlightingElement.isDisplayed(), "Syntax is not suspended for Bash.");

        // Assertion 3:
        WebElement codeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ol[@class='bash']")));
        String savedCode = codeElement.getText();
        Assert.assertEquals(savedCode, code, "Saved code does not match.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
