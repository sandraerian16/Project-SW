package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC18_Edit_Product_InStore_Invalid
{
    @Test
    public void Edit_Product()
    {
        System.setProperty("webdriver.chrome.driver","//home//andrew//Desktop//chromedriver_linux64//chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("sandra");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sandra");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(4) p:nth-child(1) > input:nth-child(1)")).click();

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(1) > input:nth-child(2)")).sendKeys("t-shirt");

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(2) > input:nth-child(2)")).sendKeys("Toy");
        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(3) > input:nth-child(2)")).clear();

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(3) > input:nth-child(2)")).sendKeys("500");
        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(4) > input:nth-child(2)")).clear();

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(4) > input:nth-child(2)")).sendKeys("60");

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(5) > input:nth-child(1)")).click();
        assertEquals("StoreEditProduct",driver.getTitle());
        driver.close();
    }

}

