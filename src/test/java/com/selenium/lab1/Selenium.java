package com.selenium.lab1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Selenium {
    public  static WebDriver driver = new ChromeDriver();

    public static void main(String[] args) {
        //calling
        openURL("https://the-internet.herokuapp.com/dynamic_loading/1");

    //    implicitlyWait(); //general dynamic for all elements to be present in DOM
        maximizeScreen();
        driver.findElement(By.cssSelector("div button")).click();
        By h4 = By.cssSelector("div#finish > h4");
        explicitWait(h4);
        String text = driver.findElement(h4).getText();

        System.out.println(text);
      /*  enterUsername("admin");
        enterPassword("admin");
        clickOnLoginButton();
        openURL("https://ashraaf7.github.io/AA-Practice-Test-Automation/Pages/dropDown.html");
        chooseFromDropDown("10+");*/
    }
    //declaration
    public static void explicitWait(By locator)
    {
        new WebDriverWait(driver,Duration.ofSeconds(5)).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void fluentWait(By locator)
    {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(50))
                .withMessage("Element is not visible " + locator)
                .ignoring(ElementNotInteractableException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static void implicitlyWait()
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    public static void chooseFromDropDown(String option)
    {
        By dropDown = By.className("container");
        Select select = new Select(driver.findElement(dropDown));
        select.selectByValue(option);
    }
    public static void enterUsername (String user)
    {
        By usernameField = By.id("inputUsername"); //locator
        driver.findElement(usernameField).sendKeys(user);
    }
    public static void enterPassword (String pass)
    {
        By passwordField = By.cssSelector("#inputPassword"); //locator
        driver.findElement(passwordField).sendKeys(pass);
    }
    public static void clickOnLoginButton()
    {
        By loginButton = By.id("loginButton");
        driver.findElement(loginButton).click();
    }
    public static void openURL(String url)
    {
        //driver.get(url);
      //  EdgeOptions options = new EdgeOptions();
       // options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver.navigate().to(url);
    }
    public static void maximizeScreen()
    {
      //  driver.manage().window().setPosition(new Point(100,100));
        driver.manage().window().maximize();
    }

}
