package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

public class TC08_AddProduct_Invalid {
    @Test
    public void Add_Product()
    {
        System.setProperty("webdriver.chrome.driver","F:\\FCI_Three\\New folder\\Chrome\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Nourhan");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("9874566");
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        driver.findElement(By.cssSelector("body > form:nth-child(1) > input[type=\"submit\"]")).click();

        driver.findElement(By.xpath("//input[@id='product_name']")).sendKeys("SamLuare");

        driver.findElement(By.xpath("//input[@id='price_start']")).sendKeys("5000");
        driver.findElement(By.xpath("//input[@id='price_end']")).sendKeys("7000");

        driver.findElement(By.xpath("//input[@id='product_brand']")).sendKeys("JennyFromTheBlock");
        driver.findElement(By.xpath("//input[@id='product_category']")).sendKeys("Musica");

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(6) > input:nth-child(1)")).click();
        assertEquals("Platform Product",driver.getTitle());
        driver.close();


    }
}
