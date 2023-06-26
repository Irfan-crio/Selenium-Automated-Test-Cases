package demo;

import java.util.List;
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


public class ImageURL {
    ChromeDriver driver;
    public ImageURL()
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

    
    public  void testCase01() throws InterruptedException{
        System.out.println("Start Test case: testCase01");
        driver.get("https://in.bookmyshow.com/explore/home/chennai");
        //Locate Image URLs list Using Locator "XPath" //*[@class='sc-lnhrs7-4 bmyqGC']//img
        WebElement recommendedMovies = driver.findElement(By.xpath("//*[@class='sc-lnhrs7-4 bmyqGC']//img"));
        String Urls = recommendedMovies.getAttribute("src");
        System.out.println(Urls);
        Thread.sleep(5000);
        //Locate 2 movie of premire list name Using Locator "XPath" //div[contains(text(),'I See You')]
        WebElement secondMovie = driver.findElement(By.xpath("//*[contains(text(),'I See You')]"));
        System.out.println(secondMovie.getText());
        WebElement language = driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[5]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/a[1]/div[1]/div[3]/div[2]/div[1]"));
        System.out.println(language.getText());
    }


}
