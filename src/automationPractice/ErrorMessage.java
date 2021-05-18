package automationPractice;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import java.util.concurrent.TimeUnit;

public class ErrorMessage {
    WebDriver driver;

    @Before
    public void setup() {
        String baseurl = "http://automationpractice.com/index.php";// url tobe checked in chrome browser
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");// key ,(driverpath) value as required in setproperty
        driver = new ChromeDriver();// driver object in ChromeDriver class to operate different functionality of webpage
        driver.manage().window().maximize();//driver object used to maximise window from manage functionality
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);// driver object used to manage timeout waiting period implicity for  webpage
        driver.get(baseurl);// driver object used to get (access) given url
    }

    @Test

    public void login() {
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.id("email")).sendKeys("sk0123@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("2345");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String expectedErrorMessage = "There is 2 error";
        WebElement errorMessageIs = driver.findElement(By.xpath("//p[text()='There is 1 error']"));

        String actualErrorMessage = errorMessageIs.getText();
        Assert.assertEquals("There is 1 error", expectedErrorMessage, actualErrorMessage);

    }

    @After

    public void teardown(){
        driver.quit();
}

    }
