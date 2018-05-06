package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;


public class TC12_ShowStores_Approve_Bug_01 {
    @Test
    public void Approve_Store()
    {
        System.setProperty("webdriver.chrome.driver","//home//andrew//Desktop//chromedriver_linux64//chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("andrew");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("andrew");
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(4) > input:nth-child(1)")).click();
        driver.findElement(By.cssSelector("body > form:nth-child(2) > input[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(1) > input:nth-child(2)")).sendKeys("sandra3");
        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) > input:nth-child(2)")).click();

        assertEquals("to_approve",driver.getTitle());
        driver.close();


    }
}
