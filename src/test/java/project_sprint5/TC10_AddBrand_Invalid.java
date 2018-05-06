package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC10_AddBrand_Invalid
{
    @Test
    public void Add_Brand()
    {
        System.setProperty("webdriver.chrome.driver","//home//andrew//Desktop//chromedriver_linux64//chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("andrew");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("andrew");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.findElement(By.xpath("//input[@value='Add Brand']")).click();
        //driver.findElement(By.cssSelector("body:nth-child(2) form:nth-child(2) > input:nth-child(1)")).click();
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("brand1");

        driver.findElement(By.xpath("//input[@id='category']")).sendKeys("Musica");
        driver.findElement(By.xpath("//input[@id='type']")).sendKeys("HollyWood");

        driver.findElement(By.xpath("/html/body/form[1]/p1/input")).click();

        assertEquals("Title",driver.getTitle());
        driver.close();

    }
}
