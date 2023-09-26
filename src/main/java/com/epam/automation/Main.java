package com.epam.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        PastebinPage pastebinPage = new PastebinPage(driver);

        // here we can input test data
        String code = "Hello from WebDriver";
        String expiration = "10 Minutes";
        String name = "helloweb";

        // Create a new paste
        pastebinPage.createNewPaste(code, expiration, name);

        // added 5 secs just to see the result on a browser before quitting
        Thread.sleep(5000);

        // Close the WebDriver instance
        driver.quit();
    }
}
