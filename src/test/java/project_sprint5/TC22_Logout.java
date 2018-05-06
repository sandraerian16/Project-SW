package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC22_Logout
{
    @Test
    public void LogOut()
    {
        System.setProperty("webdriver.chrome.driver","//home//andrew//Desktop//chromedriver_linux64//chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("sandra");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sandra");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //assertEquals("StoreOwnerPage",driver.getTitle());
        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(11) > input:nth-child(1)")).click();

        assertEquals("Login",driver.getTitle());

        driver.close();
    }
}
