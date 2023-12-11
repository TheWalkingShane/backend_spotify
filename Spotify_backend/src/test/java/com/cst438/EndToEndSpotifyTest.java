package com.cst438;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class EndToEndSpotifyTest {

    public static final String CHROME_DRIVER_FILE_LOCATION = "C:/chromeDriver_win32/chromedriver.exe";
    public static final String URL = "http://localhost:3000"; // Adjust to your application's URL

    @Test
    public void userLoginAndProfileFetchTest() throws Exception {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILE_LOCATION);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            driver.get(URL);
            Thread.sleep(1000); // Wait for the page to load

            // Assuming there's a button/link to navigate to the profile page
            WebElement profileLink = driver.findElement(By.id("profileLink"));
            profileLink.click();
            Thread.sleep(1000); // Wait for navigation

            // Check for a specific element on the profile page
            WebElement profileElement = driver.findElement(By.id("profileElement"));
            assertNotNull(profileElement, "Profile element not found");

            // Additional assertions and interactions...

        } catch (Exception ex) {
            throw ex;
        } finally {
            driver.quit();
        }
    }
}


