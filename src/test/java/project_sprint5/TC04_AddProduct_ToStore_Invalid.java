package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC04_AddProduct_ToStore_Invalid {
    @Test
    public void Add_Product_Store()
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
        //driver.findElement(By.xpath("//form[@action='/AddProducttostore']//p//input[@type='submit']")).click();
        driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(2) p:nth-child(1) > input:nth-child(1)")).click();


        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Jenaa");
        driver.findElement(By.xpath("//input[@id='product_type']")).sendKeys("Toy");
        driver.findElement(By.xpath("//input[@id='store_ID']")).sendKeys("ShereenStore");
        driver.findElement(By.xpath("//input[@id='price']")).clear();

        driver.findElement(By.xpath("//input[@id='price']")).sendKeys("56500");
        driver.findElement(By.xpath("//input[@id='quntity']")).clear();

        driver.findElement(By.xpath("//input[@id='quntity']")).sendKeys("10");
        driver.findElement(By.xpath("//form[@action='/AddProducttostore']//p//input[@type='submit']")).click();

        assertEquals("AddProduct",driver.getTitle());
        driver.close();
    }

}
