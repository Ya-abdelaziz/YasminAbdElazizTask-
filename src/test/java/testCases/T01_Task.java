package testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.TaskPage;

import java.time.Duration;

public class T01_Task {
    WebDriver driver;
    TaskPage taskPage;


    @Test
    public void searchGoogleTask() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        taskPage.search1("testing");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='erkvQe'] div[class='OBMEnb'] ul[class='G43f7e']")));

        taskPage.clearSearchInput();

        WebDriverWait wait1 = new WebDriverWait(driver,Duration.ofSeconds(5));
        taskPage.search1("automation");
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("div[class='erkvQe'] div[class='OBMEnb'] ul[class='G43f7e']")));

        taskPage.clickSearch();

       TaskPage resultPage = new TaskPage(driver);
        Assert.assertTrue(resultPage.getResultsCount() > 0);



        taskPage.scrollDown();


        int numOfResultsPage2 = taskPage.getResultsCount();
        taskPage.scrollDown();
        int numOfResultsPage3 = taskPage.getResultsCount();
        Assert.assertEquals(numOfResultsPage2, numOfResultsPage3);



      //  Assert.assertTrue(taskPage.suggestionsDisplayed(), "Search suggestions not found.");



    }




    @BeforeClass
    public void setup(){

        driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        taskPage = new TaskPage(driver);
    }


    @AfterClass
    public void teardown()
    {
        driver.close();
    }
}
