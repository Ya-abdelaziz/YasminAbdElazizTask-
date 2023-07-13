package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class TaskPage {
    WebDriver driver;

    public TaskPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox = By.id("APjFqb");

    private By searchInput = By.name("q");
    private By searchButton = By.name("btnK");
    private By searchResult = By.xpath("//div[contains(@class,\"MjjYud\")]");
    //cssSelector("#search .g");

    private By nextPage = By.id("pnnext");


    public void search1(String search1) {
        driver.findElement(searchBox).sendKeys(search1);
    }

    public void clearSearchInput() {
        driver.findElement(searchInput).clear();
    }

    public void clickSearch() {
        driver.findElement(searchButton).click();
    }

    public int getResultsCount() {
        return driver.findElements(searchResult).size();
    }


    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        driver.findElement(nextPage).click();

    }

   /* public boolean suggestionsDisplayed()
    {
       return driver.findElements(By.className("s75CSd u60jwe r2fjmd AB4Wff")).isEmpty();
    }

    */




}

