package com.epam.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        PastebinPage pastebinPage = new PastebinPage(driver);

        // Test data
        String code = "Hello from WebDriver";
        String expiration = "10 Minutes";
        String name = "helloweb";

        try {
            // Create a new paste
            pastebinPage.createNewPaste(code, expiration, name);
        } finally {
            // Close the WebDriver instance
            driver.quit();
        }
    }
}
