package com.cst438;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class EndToEndSpotifyTest {

    public static final String CHROME_DRIVER_FILE_LOCATION = "your file location";
    public static final String URL = "http://localhost:3000"; // Adjust to your application's URL

    @Test
    public void userLoginAndProfileFetchTest() throws Exception {
    	
    	/////////////////////////////////////////////////////////
    	// DONT FORGET TO SET YOUR CHROME DRIVER FILE LOCATION //
    	/////////////////////////////////////////////////////////
    	
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_FILE_LOCATION);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        try {
            driver.get(URL);
            Thread.sleep(1000); // Wait for the page to load

            // Click the play quiz button
            WebElement playQuiz = driver.findElement(By.xpath("//*[@id=\"basic-navbar-nav\"]/div[1]/a[1]"));
            playQuiz.click();
            
            Thread.sleep(1000); // Wait for the page to load
            
            // CLikc the play button
            WebElement playGame = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div/div/div[1]/div[3]/div/button")); 
            playGame.click();
            
            Thread.sleep(1000);
            
            // Get the number of questions
            WebElement getNumberOfQuestions = driver.findElement(By.xpath("//*[@id=\"backgroundQuiz\"]/div/div/div/div/div[4]/p")); 
            String number = getNumberOfQuestions.getText();
            Integer questions = Integer.parseInt(number.substring(number.length() - 2));
            
            for(int i = 0; i < questions; i++) {
            	 Thread.sleep(1000);
            	// Clicks the first choice
            	WebElement buttonChoice = driver.findElement(By.xpath("//*[@id=\"backgroundQuiz\"]/div/div/div/div/div[2]/div[1]/button")); 
            	buttonChoice.click(); // clicks the button
            	
            	// Clicks confirm answer
            	WebElement confirm = driver.findElement(By.xpath("//*[@id=\"backgroundQuiz\"]/div/div/div/div/div[4]/button")); 
            	confirm.click(); // clicks the button
            	
            	// Clicks next button
            	WebElement next = driver.findElement(By.xpath("//*[@id=\"backgroundQuiz\"]/div/div/div/div/div[4]/button")); 
            	next.click(); // clicks the button
    
            }
            
            Thread.sleep(1000);
            // checks if quiz is completed
            WebElement checkCompletedQuiz = driver.findElement(By.xpath("//*[@id=\"backgroundQuiz\"]/div/div/div/div/h3")); 
        	String result = checkCompletedQuiz.getText();
        	
        	assertTrue(result.contains("Quiz Completed!"), "Text does not match");

            
            Thread.sleep(1000);
                     

        } catch (Exception ex) {
            throw ex;
        } finally {
            driver.quit();
        }
    }
}


