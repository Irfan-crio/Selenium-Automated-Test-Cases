package demo;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class LinkedInPost {
    ChromeDriver driver;
    public LinkedInPost()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        // Navigate to URL  "https://www.linkedin.com/uas/login?session_redirect=https%3A%2F%2Fwww.linkedin.com%2Ffeed%2F"
        driver.get("https://www.linkedin.com/uas/login?session_redirect=https%3A%2F%2Fwww.linkedin.com%2Ffeed%2F");
        driver.findElement(By.xpath("//*[contains(text(), 'Sign in')]")).click();
        // Locate Username field Using Locator "ID" "username" and write user name
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("irfanahmed7240@gmail.com");
        // Locate Password field Using Locator "ID" "password" | .sendKeys("Test")
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("Irfan@7240");
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        // Locate `Who's viewed your profile` section Using Locator "XPath" //*[contains(text(),"Who's viewed your profile")]
        driver.findElement(By.xpath("//*[contains(text(),\"Who's viewed your profile\")]")).click();
        WebElement viewedCount = driver.findElement(By.xpath("//*[@class='text-body-medium-bold pr1 text-heading-large']"));
        System.out.println("No of people viewed profile " + viewedCount.getText());
        driver.navigate().back();
        //Locate start a post section Using Locator "ID" "ember1077"
        driver.findElement(By.id("ember1077")).click();
        driver.findElement(By.xpath("//body/div[@id='artdeco-modal-outlet']/div[@id='ember1229']/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/p[1]")).sendKeys("TestPost");
        // Locate post button Using Locator "ID" "ember1314"
        //driver.findElement(By.id("ember1314")).click();
        //Locate Post Using Locator "XPath" //*[contains(text(), "Test Post")]
        driver.findElement(By.xpath("//*[contains(text(), 'Test Post')]")).isDisplayed();

        System.out.println("end Test case: testCase02");
    }


}
