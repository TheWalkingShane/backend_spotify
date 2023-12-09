package com.cst438;


import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EndToEndSpotifyTest {

    public static final String CHROME_DRIVER_FILE_LOCATION = "path/to/chromedriver.exe";
    public static final String URL = "http://localhost:3000"; // Adjust to your application's URL

    @Test
    public void userLoginAndProfileFetchTest() throws Exception {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILE_LOCATION);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            driver.get(URL);
            Thread.sleep(1000); // Wait for the page to load

            // Add steps to interact with your web application
            // For example, login (if not using OAuth), navigate to user profile page, etc.

            // Check for certain elements to verify successful interaction
            // Example: WebElement profileElement = driver.findElement(By.id("profileElementId"));
            // assertNotNull(profileElement, "Profile element not found");

            // More interactions and assertions as needed for your test scenario

        } catch (Exception ex) {
            throw ex;
        } finally {
            driver.quit();
        }
    }
}


