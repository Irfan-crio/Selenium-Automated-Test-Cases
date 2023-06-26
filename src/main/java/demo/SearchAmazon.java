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


public class SearchAmazon {
    ChromeDriver  driver;
    public SearchAmazon()
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
        driver.get("https://www.google.com");
        //Locate the search field Using Locator "XPath" //*[@id='APjFqb']
        WebElement searchField = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        searchField.click();
        searchField.sendKeys("Amazon");
        //click on google search button Using Locator "XPath" //input[@class='gNO89b'] | .sendkeys("amazon")
        WebElement searchButton = driver.findElement(By.xpath("//input[@class='gNO89b']"));
        searchButton.click();
        //validate the search result Using Locator "XPath" //h3[text()='Amazon.in'] | .isDisplayed()
        WebElement amazonLink = driver.findElement(By.xpath("//h3[text()='Amazon.in']"));
        System.out.println("The link is displayed" + amazonLink.isDisplayed());
        System.out.println("end Test case: testCase02");
    }


}
