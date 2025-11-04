package Runonjenkinsserver;

import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestVWOLogin2 {

    EdgeOptions options;
    WebDriver driver;


    @BeforeSuite
    public void setup()
    {
        options=new EdgeOptions();
        options.addArguments("--start-maximized");
        driver = new EdgeDriver(options);
    }


    @Test(enabled = true, priority = 2, groups = {"positive", "sanity", "stage"} )
    @Description("Verify that with Valid username and Valid password, Login is successfull !!")
    public void TestValidLogin()  {

        // ID, Name, ClassName -> CssSelector, Xppath - Firefox or Chrome
        // xpath. CSS Selector -> Chrome, will not work Firefox.


        driver.get("https://app.vwo.com/#/login");
        driver.findElement(By.id("login-username")).sendKeys("vemulaabhilash8433@gmail.com");
        driver.findElement(By.id("login-password")).sendKeys("VAS1933@hyd");
        driver.findElement(By.id("js-login-btn")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-qa='page-heading']")));

        //<h4 class="page-heading ng-binding" data-qa="page-heading">Dashboard</h4>
        // Assertion
        // Expected Result == Actual Result

        Assert.assertEquals(driver.getTitle(), "Dashboard");
        Assert.assertEquals(driver.getCurrentUrl(), "https://app.vwo.com/#/dashboard?accountId=815570");

        driver.get("https://app.vwo.com/logout");


    }

    @AfterSuite
    public void tearDown() {
        driver.quit();
    }



}
