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

public class BasePageSearchValidate extends BasePage {

    public BasePageSearchValidate(WebDriver driver) {
        super(driver);
    }

    private final By textInput = By.xpath("//input[@id='search_form_input_homepage']");

    List<String> actualAutocompleteWords = new ArrayList<>();

    public BasePageSearchValidate inputValidate() {
        WebElement input = driver.findElement(textInput);
        input.sendKeys(KEY_WORD);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        List<WebElement> allAutocompleteWords = driver.findElements(By.className("acp"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));

        for (WebElement Word : allAutocompleteWords){
            actualAutocompleteWords.add(Word.getText());
            System.out.println("Autocomplete text: " + Word.getText());
        }
        System.out.println("actualAutocompleteWords length is : " + actualAutocompleteWords.size());
        Assert.assertEquals(actualAutocompleteWords.size(), 8);
        return this;
    }
}