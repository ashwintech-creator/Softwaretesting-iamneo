package com.iamneo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    @Test(dataProvider = "loginData", dataProviderClass = AppTest.class)
    public void testLogin(String username, String password) throws InterruptedException {
        // Set the path to the chromedriver executable
        //System.setProperty("webdriver.chrome.driver", "path_to_chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the login page of your web application
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Find the username and password fields and enter the provided credentials
        WebElement usernameField = driver.findElement(By.id("username"));
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys(password);

        // Find and click the login button
        WebElement loginButton = driver.findElement(By.id("submit"));
        loginButton.click();
        Thread.sleep(5000);

        // Add assertions or further actions based on the login result
        // For example, you can verify if the login was successful or not
        
        // Close the browser
        driver.quit();
    }
}
