package com.anirbandhara.testrunners;

import com.anirbandhara.setup.SetUp;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.anirbandhara.pages.LoginPage;
import com.anirbandhara.pages.PIMPage;



public class LoginTExecutor extends SetUp {

    PIMPage dashboardPage;
    LoginPage loginPage;

    @Test(priority = 1, description = "Login with invalid password.")
    public void doFailedLogin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage.doLogin("Admin", "donda123");
        String expectedText = "Invalid credentials";
        String actualText = driver.findElement(By.className("oxd-alert-content-text")).getText();
        Assert.assertTrue(actualText.contains(expectedText));
        Thread.sleep(2000);
    }

    @Test(priority = 2, description = "Login with valid credentials.")
    public void dologin() throws InterruptedException {
        loginPage = new LoginPage(driver);
        driver.get("https://opensource-demo.orangehrmlive.com");
        loginPage.doLogin("Admin", "admin123");
        Thread.sleep(5000);
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "dashboard";
        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }

    @Test(priority = 3, description = "Check if Profile Picture exists.")
    public void ifProfilePictureExist() {
        boolean imageExist = driver.findElement(By.className("oxd-userdropdown-img")).isDisplayed();
        Assert.assertTrue(imageExist);
    }

    @Test(priority = 4, description = "Checking the Log Out functionality.")
    public void doLogout() {
        dashboardPage = new PIMPage(driver);
        dashboardPage.profilePicture.click();
        dashboardPage.logoutButton.click();

    }
}
