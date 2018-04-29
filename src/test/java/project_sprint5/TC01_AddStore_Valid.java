package project_sprint5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC01_AddStore_Valid
{
 @Test
 public void AddStore()
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
     driver.findElement(By.xpath("/html/body/form[1]/p/input")).click();



     driver.findElement(By.xpath("//input[@id='store_name']")).sendKeys("Selia");
     driver.findElement(By.xpath("//input[@id='store_telephone']")).sendKeys("+9663465fdff6565184");
     driver.findElement(By.xpath("//input[@id='type']")).sendKeys("Beauty");
     driver.findElement(By.xpath("//input[@id='store_address']")).sendKeys("Jordon");
     driver.findElement(By.xpath("//select[@id='location']")).sendKeys("onLine");
     driver.findElement(By.xpath("//form[@action='/Addstore1']//p//input[@type='submit']")).click();

     assertEquals("StoreOwnerPage",driver.getTitle());
     driver.close();
 }
}
