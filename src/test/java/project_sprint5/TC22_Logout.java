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
        System.setProperty("webdriver.chrome.driver","F:\\FCI_Three\\New folder\\Chrome\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Alaa");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("125");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //assertEquals("StoreOwnerPage",driver.getTitle());
        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(10) > input:nth-child(1)")).click();

        assertEquals("Login",driver.getTitle());

        driver.close();
    }
}
