package demo;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
//Selenium Imports
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
///


public class WindowHandle {
    ChromeDriver driver;
    public WindowHandle()
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
        // Navigate to the page with the "Try it" button
        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_win_open");

        // Switch to the iframe containing the "Try it" button
        driver.switchTo().frame("iframeResult");

        // Click on the "Try it" button
        WebElement tryItButton = driver.findElement(By.tagName("button"));
        tryItButton.click();

        // Get the window handle of the original window
        String originalWindowHandle = driver.getWindowHandle();

        // Get all the window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to the new window
        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(originalWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        // Get the URL of the new window
        String newWindowUrl = driver.getCurrentUrl();

        // Get the title of the new window
        String newWindowTitle = driver.getTitle();

        // Take a screenshot of the new window
        // Replace "path/to/screenshot.png" with the desired path and filename for the screenshot
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("path/to/screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the new window
        driver.close();

        // Switch back to the original window
        driver.switchTo().window(originalWindowHandle);

        // Print the URL, Title, and screenshot path
        System.out.println("URL of the new window: " + newWindowUrl);
        System.out.println("Title of the new window: " + newWindowTitle);
        System.out.println("Screenshot path: path/to/screenshot.png");
        System.out.println("end Test case: testCase02");
    }


}
