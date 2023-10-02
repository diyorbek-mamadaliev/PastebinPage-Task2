package com.epam.automation;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

class PastebinPageTest {

    private WebDriver driver;
    private PastebinPage pastebinPage;

    @BeforeEach
    void setUp() {

        driver = new ChromeDriver();


        pastebinPage = new PastebinPage(driver);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void createNewPasteWithValidData() {
        // Test with valid data
        String code = "This is a test code.";
        String expiration = "10 Minutes";
        String highlight = "Bash";
        String name = "Test Paste";

        pastebinPage.createNewPaste(code, expiration, highlight, name);

        String expectedTitle = "Test Paste - Pastebin.com";
        assertEquals(expectedTitle, driver.getTitle());

    }
}
