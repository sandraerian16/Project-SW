package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC15_Search_Product_Buy_Valid
{
    @Test
    public void Search_Store()
    {
        System.setProperty("webdriver.chrome.driver","F:\\FCI_Three\\New folder\\Chrome\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Alaa");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("125");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(5) p:nth-child(1) > input:nth-child(1)")).click();

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(2) p:nth-child(1) > input:nth-child(1)")).click();

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(1) > input:nth-child(1)")).sendKeys("cds");
        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(2) > input:nth-child(1)")).sendKeys("1");
        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(3) > input:nth-child(1)")).sendKeys("Maadi");

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(4) > input:nth-child(1)")).click();
        assertEquals("StoreOwnerPage",driver.getTitle());
        driver.close();
    }
}
