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


public class IMDBratings {
    ChromeDriver driver;
    public IMDBratings()
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
        driver.get("https://www.imdb.com/chart/top");

        // Get the highest rated movie
        WebElement highestRatedMovieElement = driver.findElement(By.xpath("//a[contains(text(),'The Shawshank Redemption')]"));
        String highestRatedMovie = highestRatedMovieElement.getText();

        // Get the number of movies in the table
        int moviesCount = driver.findElements(By.xpath("//tbody//tr")).size();

        // Get the oldest movie on the list
        WebElement oldestMovieElement = driver.findElement(By.xpath("//a[contains(text(),'The Kid')]"));
        String oldestMovie = oldestMovieElement.getText();

        // Get the most recent movie on the list
        WebElement recentMovieElement = driver.findElement(By.xpath("//a[contains(text(),'Spider-Man: Across the Spider-Verse')]"));
        String recentMovie = recentMovieElement.getText();

        // Get the movie with the most user ratings
        WebElement mostRatedMovieElement = driver.findElement(By.xpath("//a[contains(text(),'The Shawshank Redemption')]"));
        String mostRatedMovie = mostRatedMovieElement.getText();

        // Print the results
        System.out.println("Highest rated movie: " + highestRatedMovie);
        System.out.println("Number of movies in the table: " + moviesCount);
        System.out.println("Oldest movie: " + oldestMovie);
        System.out.println("Most recent movie: " + recentMovie);
        System.out.println("Movie with the most user ratings: " + mostRatedMovie);
        System.out.println("end Test case: testCase02");
    }


}
