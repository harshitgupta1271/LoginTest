package login;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class positiveLoginFlow {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/practice-test-login/");
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        if (driver != null) {
            driver.quit();
        }
    }

   @Test(priority = 1)
    public void login() throws InterruptedException {
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("student");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Password123");
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        String currentUrl = driver.getCurrentUrl();

        WebElement heading = driver.findElement(By.xpath("//strong[contains(text(),'Congratulations student. You successfully logged in!')]"));
        WebElement logoutBtn = driver.findElement(By.xpath("//a[text()='Log out']"));

        if (currentUrl.contains("practicetestautomation.com/logged-in-successfully/")
                && heading.getText().equals("Congratulations student. You successfully logged in!")
                && logoutBtn.isDisplayed()) {
            System.out.println("Positive login flow passed");
        } else {
            System.out.println("Positive login flow failed");
            takeScreenshot("LoginFailed");
        }
        Thread.sleep(2000);
    }
    
    public void takeScreenshot(String testName) {
        try {
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            File dest = new File(System.getProperty("user.dir") + "/screenshots/" + testName + "_" + timestamp + ".png");
            Files.copy(src, dest);
            System.out.println("Screenshot saved: " + dest.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Failed to take screenshot: " + e.getMessage());
        }
    }

    public void performNegativeLogin(String username, String password, String expectedError, String testName) throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.findElement(By.xpath("//input[@id='username']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@id='submit']")).click();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement error = wait.until(driver -> {
                WebElement el = driver.findElement(By.xpath("//div[@id='error']"));
                return !el.getText().trim().isEmpty() ? el : null;
            });

            String e = error.getText().trim();

            if (e.equals(expectedError)) {
                System.out.println(testName + " Passed");
            } else {
                
                System.out.println(testName + " Failed - Wrong error message");
                takeScreenshot(testName + "_WrongMessage");
            }
        } catch (Exception ex) {
            System.out.println(testName + " Failed - Error message missing or not visible.");
            takeScreenshot(testName + "_ErrorMissing");
        }
        Thread.sleep(3000);
    }

  @Test(priority = 2)
    public void testIncorrectUsername() throws InterruptedException {
        performNegativeLogin("incorrectUser", "Password123", "Your username is invalid!", "IncorrectUsername");
    }
   @Test(priority = 3)
    public void testIncorrectPassword() throws InterruptedException {
        performNegativeLogin("student", "incorrectPassword", "Your password is invalid!", "IncorrectPassword");
    }
  
   @Test(priority = 4)
    public void testBothIncorrect() throws InterruptedException {
        performNegativeLogin("wrongUser", "wrongPass", "Your username is invalid!", "BothIncorrect");
    }


   @Test(priority = 5)
    public void accessControlTest() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://practicetestautomation.com/logged-in-successfully/");

        // Wait a bit to let page load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

     
        String actualTitle = driver.getTitle();
      
       
        if (actualTitle.equals("Logged In Successfully | Practice Test Automation") || driver.getCurrentUrl().contains("logged-in-successfully")) {
            System.out.println("Access Control Test Failed: Page loaded without login - SECURITY ISSUE");
            takeScreenshot("AccessControl_SecurityIssue");
           
            
        } else {
            System.out.println("Access Control Test Passed: Access restricted without login.");
        }
        System.out.println();
    }

}

































