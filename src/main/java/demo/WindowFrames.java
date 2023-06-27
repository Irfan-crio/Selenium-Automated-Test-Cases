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


public class WindowFrames {
    ChromeDriver driver;
    public WindowFrames()
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
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        Thread.sleep(5000);
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        WebElement leftString = driver.findElement(By.xpath("//body"));
        System.out.println(leftString.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleString = driver.findElement(By.xpath("//div[@id='content']"));
        System.out.println(middleString.getText());
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightString = driver.findElement(By.xpath("//body"));
        System.out.println(rightString.getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame("frame-bottom");
        WebElement bottomString = driver.findElement(By.xpath("//body"));
        System.out.println(bottomString.getText());
        System.out.println("end Test case: testCase02");
    }


}
