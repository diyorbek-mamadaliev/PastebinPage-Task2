package com.epam.automation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Main {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        PastebinPage pastebinPage = new PastebinPage(driver);

        // test data
        String code = "Hello from WebDriver";
        String expiration = "10 Minutes";
        String name = "helloweb";

        try {
            // create a new paste
            pastebinPage.createNewPaste(code, expiration, name);
        } finally {
            // close the WebDriver
            driver.quit();
        }
    }
}
