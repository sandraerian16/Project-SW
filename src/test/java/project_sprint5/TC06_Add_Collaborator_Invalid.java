package project_sprint5;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

public class TC06_Add_Collaborator_Invalid {
    @Test
    public void Add_Product_Store()
    {
        System.setProperty("webdriver.chrome.driver","//home//andrew//Desktop//chromedriver_linux64//chromedriver");
        WebDriver driver= new ChromeDriver();
        driver.get("http://localhost:8080/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("sandra");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sandra");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //assertEquals("StoreOwnerPage",driver.getTitle());
        driver.findElement(By.xpath("/html/body/form[9]/input")).click();

        driver.findElement(By.xpath("//input[@id='store_name']")).sendKeys("sandra1");
        driver.findElement(By.xpath("//form[@action='/Add_Col']//input[@type='submit']")).click();
        driver.findElement(By.xpath("//form[@action='/Add_Colla']//input[@type='submit']")).click();

        driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Fairouza");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='bank_account']")).sendKeys("Maddd_p");
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("Mad");
        driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Maadi");

        driver.findElement(By.xpath("//form[@action='/Add_Colla']//p//input[@type='submit']")).click();

        assertEquals("AddCollaborators",driver.getTitle());

        driver.close();
    }
}
