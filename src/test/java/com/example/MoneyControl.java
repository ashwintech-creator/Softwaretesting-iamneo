package com;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MoneyControl 
{
    public static void main(String[] args) throws InterruptedException
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moneycontrol.com/");
        driver.manage().window().maximize();
        Thread.sleep(15000);
        driver.findElement(By.xpath("//*[@id='search_str']")).sendKeys("Reliance Industries Ltd.");
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='autosuggestlist']/ul/li[1]/a")).click();
        driver.findElement(By.linkText("Mutual Funds")).click();
        driver.findElement(By.linkText("MC 30")).click();
        driver.findElement(By.linkText("SIP")).click();
    }

 
    

    
}
