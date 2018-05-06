package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC13_Delete_Product_FromStore_Valid
{
    @Test
    public void Delete_Store()
    {
        System.setProperty("webdriver.chrome.driver","//home//andrew//Desktop//chromedriver_linux64//chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("sandra");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sandra");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.cssSelector("body > form:nth-child(5) > p > input[type=\"submit\"]")).click();

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(1) > input:nth-child(2)")).sendKeys("mobile");
        driver.findElement(By.xpath("//select[@id='store_ID']")).sendKeys("sandra2");

        driver.findElement(By.cssSelector("body > form:nth-child(1) > p:nth-child(3) > input[type=\"submit\"]")).click();

        assertEquals("StoreOwnerPage",driver.getTitle());
        driver.close();
    }
}
