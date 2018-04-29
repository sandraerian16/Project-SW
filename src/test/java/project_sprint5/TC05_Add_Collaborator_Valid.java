package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC05_Add_Collaborator_Valid
{
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
        driver.findElement(By.xpath("/html/body/form[9]/input")).click();

        driver.findElement(By.xpath("//input[@id='store_name']")).sendKeys("ShereenStores");
        driver.findElement(By.xpath("//form[@action='/Add_Col']//input[@type='submit']")).click();
        driver.findElement(By.xpath("//form[@action='/Add_Colla']//input[@type='submit']")).click();

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Alexandra");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("1557820149529");
        driver.findElement(By.xpath("//input[@id='bank_account']")).sendKeys("Alexandra");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Alexandra987215@gmail.com");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Paris");

        driver.findElement(By.xpath("//form[@action='/Add_Colla']//p//input[@type='submit']")).click();

        assertEquals("StoreOwnerPage",driver.getTitle());
        driver.close();
    }

}
