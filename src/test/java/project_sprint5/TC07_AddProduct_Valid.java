package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC07_AddProduct_Valid {
    @Test
    public void Add_Product()
    {
        System.setProperty("webdriver.chrome.driver","//home//andrew//Desktop//chromedriver_linux64//chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("andrew");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("andrew");
        driver.findElement(By.xpath("//input[@type='submit']")).click();


        driver.findElement(By.xpath("//input[@value='ADD Product']")).click();

        //driver.findElement(By.cssSelector("body > form:nth-child(1) > input[type=\"submit\"]")).click();

        driver.findElement(By.xpath("//input[@id='product_name']")).sendKeys("t-shirt");

        driver.findElement(By.xpath("//input[@id='price_start']")).sendKeys("5200");
        driver.findElement(By.xpath("//input[@id='price_end']")).sendKeys("7000");

        driver.findElement(By.xpath("//input[@id='product_brand']")).sendKeys("brand1");
        driver.findElement(By.xpath("//input[@id='product_category']")).sendKeys("Musica");

        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(1) p:nth-child(6) > input:nth-child(1)")).click();
        assertEquals("AdministratorPage",driver.getTitle());
        driver.close();


    }
}
