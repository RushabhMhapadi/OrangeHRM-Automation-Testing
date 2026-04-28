package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


public class LoginTest {

    public static void main(String[] args) {

        //  ChromeDriver location
        System.setProperty("webdriver.chrome.driver",
                           "C:\\chromedriver\\chromedriver.exe");

        // launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Maximize window
        driver.manage().window().maximize();

        //wait before loading of page
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // Open OrangeHRM website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // username
        driver.findElement(By.name("username")).sendKeys("Admin");

        // password
        driver.findElement(By.name("password")).sendKeys("admin123");

        // Click Login button
        driver.findElement(
            By.cssSelector("button[type='submit']")).click();

        // Print page title to verify login worked
        //System.out.println("Page Title: " + driver.getTitle());
        
     // Get  page title
        String actualTitle = driver.getTitle();

        // Check if title contains text "OrangeHRM"
        if (actualTitle.contains("OrangeHRM")) 
        {
            System.out.println("✅ Valid Login Test PASSED — Title: " + actualTitle);
        } 
        else 
        {
            System.out.println("❌ Valid Login Test FAILED — Title: " + actualTitle);
        }

        // Close browser
        driver.quit();
        
     // invalid login test call
        invalidLoginTest();

    }
    public static void invalidLoginTest() {

       
        System.setProperty("webdriver.chrome.driver",
                           "C:\\chromedriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.name("username")).sendKeys("wrongUser");
        driver.findElement(By.name("password")).sendKeys("wrongPass");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        String errorMessage = driver.findElement(
            By.cssSelector(".oxd-alert-content-text")).getText();
        
        //System.out.println("Error Message: " + errorMessage);
    
       
        if (errorMessage.contains("Invalid credentials")) 
        {
            System.out.println("✅ Invalid Login Test PASSED — Message: " + errorMessage);
        } 
        else 
        {
            System.out.println("❌ Invalid Login Test FAILED — Message: " + errorMessage);
        }

        driver.quit();

    }
}