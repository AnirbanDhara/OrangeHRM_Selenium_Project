package com.anirbandhara.setup;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class SetUp {
    public WebDriver driver;

    @BeforeTest
    public void setup (){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @AfterTest
    public void closeDriver() { driver.quit(); }
}
