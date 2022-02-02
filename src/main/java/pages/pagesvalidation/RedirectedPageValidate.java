package pages.pagesvalidation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.base.BasePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static constants.Constant.KeyWords.KEY_WORD;
import static constants.Constant.TimeoutVariable.IMPLICIT_WAIT;

public class RedirectedPageValidate extends BasePage {

    public RedirectedPageValidate(WebDriver driver) {

        super(driver);
    }

    private final By textInput = By.xpath("//input[@id='search_form_input_homepage']");

    List<String> actualLeftColumnResults = new ArrayList<>();
    List<String> moreResultsLeftColumn = new ArrayList<>();

    public RedirectedPageValidate redirectionToSearchResultsPage(){
        WebElement input = driver.findElement(textInput);
        input.sendKeys(KEY_WORD);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.findElement(By.id("search_button_homepage")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        List<WebElement> allRightColumnResults = driver.findElements(By.xpath("//*[@class='module__title__link']"));
        Assert.assertEquals(allRightColumnResults.size(), 1);
        System.out.println("allRightColumnResults length is : " + allRightColumnResults.size());

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        List<WebElement> allLeftColumnResults = driver.findElements(By.xpath("//*[@id=\"links\"]/div/div/h2"));

        for (WebElement Result : allLeftColumnResults){
            actualLeftColumnResults.add(Result.getText());
            System.out.println("Results: " + Result.getText());
        }
        System.out.println("actualLeftColumnResults length is : " + actualLeftColumnResults.size());
        Assert.assertEquals(actualLeftColumnResults.size(), 10);
        return this;
    }

    public RedirectedPageValidate moreResults(){
        WebElement input = driver.findElement(textInput);
        input.sendKeys(KEY_WORD);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        driver.findElement(By.id("search_button_homepage")).click();

        driver.findElement(By.xpath("//*[@class='result--more__btn btn btn--full']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        List<WebElement> allLeftColumnResults = driver.findElements(By.xpath("//*[@id=\"links\"]/div/div/h2"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        for (WebElement Result : allLeftColumnResults){
            moreResultsLeftColumn.add(Result.getText());
            System.out.println("Results: " + Result.getText());
        }
        System.out.println("moreResultsLeftColumn length is : " + moreResultsLeftColumn.size());
        Assert.assertEquals(moreResultsLeftColumn.size(), 29);
        //Assert.assertEquals(moreResultsLeftColumn.size(), 20);
        return this;
    }

    public RedirectedPageValidate resultsCompare(){
        for (String element : actualLeftColumnResults){
            if (moreResultsLeftColumn.contains(element)){
                continue;
            }else {
                Assert.fail("More Results is not contains the previous results!");
            }
        }
        Assert.assertTrue(true);
        System.out.println("More Results is contains the previous results!");
        return this;
    }
}