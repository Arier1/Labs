package com.opensourceDemoOrangehrmlive;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;

public class auth{

    private static WebDriver driver;
    private static Login login;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\poper\\Downloads\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        login = new Login(driver);
    }

    @Test
    public void auth() {
        WebElement element;
        /*alternative login method using xpath
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        driver.findElement(By.xpath("//input[@id=\"txtUsername\"]")).sendKeys("Admin");
        driver.findElement(By.xpath("//input[@id=\"txtPassword\"]")).sendKeys("admin123");
        driver.findElement(By.xpath("//input[@id=\"btnLogin\"]")).click();*/
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        login.signIn("Admin", "admin123");
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/admin/viewJobTitleList");
        /*Adding Job Title, Desc and notes*/
        driver.findElement(By.xpath("//input[@id=\"btnAdd\"]")).click();
        driver.findElement(By.xpath("//input[@id='jobTitle_jobTitle']")).sendKeys("test2");
        driver.findElement(By.xpath("//*[@id='jobTitle_jobDescription']")).sendKeys("test desc2");
        driver.findElement(By.xpath("//*[@id='jobTitle_note']")).sendKeys("test note2");
        driver.findElement(By.xpath("//input[@id=\"btnSave\"]")).click();
        /*Editing Job Desc*/
        driver.findElement(By.xpath("//a[text()='" + "test2" + "']")).click();
        driver.findElement(By.xpath("//input[@value='Edit']")).click();
        driver.findElement(By.xpath("//*[@id='jobTitle_jobDescription']")).clear();
        driver.findElement(By.xpath("//*[@id='jobTitle_jobDescription']")).sendKeys("test desc new");
        driver.findElement(By.xpath("//input[@value='Save']")).click();
        /*Removing our field*/
        driver.findElement(By.xpath("//tr//td//a[text()='" + "test2" + "']//..//..//td//input")).click();
        driver.findElement(By.xpath("//input[@id=\"btnDelete\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"dialogDeleteBtn\"]")).click();
        /*check if everuthing's correct*/
        var checker = driver.findElements(By.xpath("//a[text()='" + "test2" + "']"));
        Assert.assertEquals(0, checker.size());
    }
    @After
    public void close() {
        driver.quit();
    }
}
