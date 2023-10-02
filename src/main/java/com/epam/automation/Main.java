package com.epam.automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        PastebinPage pastebinPage = new PastebinPage(driver);

        // here we can input test data
        String code = """
                git config --global user.name  "New Sheriff in Town"
                git reset $(git commit-tree HEAD^{tree} -m "Legacy code")
                git push origin master --force""";
        String expiration = "10 Minutes";
        String highlight = "Bash";
        String name = "how to gain dominance among developers";

        pastebinPage.createNewPaste(code, expiration, highlight, name);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Verify page title
        WebElement titleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='how to gain dominance among developers']")));
        if (titleElement.isDisplayed()) {
            System.out.println("✓ Expected browser page title: " + name + "." + "\nActual: " + titleElement.getText() + ".");
        } else {
            System.out.println("Browser page title does not match!");
        }

        // Verify syntax highlighting
        WebElement syntaxHighlightingElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Bash']")));
        if (syntaxHighlightingElement.isDisplayed()) {
            System.out.println("\n✓ Expected syntax suspended: " + highlight + "." + "\nActual: " + syntaxHighlightingElement.getText() + ".");
        } else {
            System.out.println("Syntax is not suspended for Bash.");
        }

        // check that the code matches the one from paragraph 2
        WebElement codeElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ol[@class='bash']")));
        String savedCode = codeElement.getText();
        if (savedCode.equals(code)) {
            System.out.println("\n✓ Expected code: " + code + "." + "\n" + "\nActual: '" + savedCode + "'.");
        } else {
            System.out.println("The saved code does not match!");
        }

        // Close the WebDriver instance
        driver.quit();
    }
}
