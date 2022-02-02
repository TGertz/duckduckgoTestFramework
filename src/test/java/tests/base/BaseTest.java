package tests.base;

import common.CommonActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import pages.base.BasePage;
import pages.pagesvalidation.BasePageSearchValidate;
import pages.pagesvalidation.RedirectedPageValidate;

import static common.Config.CLEAR_COOKIES_AND_STORAGE;
import static common.Config.HOLD_BROWSER_OPEN;

public class BaseTest {
    protected WebDriver driver = CommonActions.createDriver();
    protected BasePage basePage = new BasePage(driver);
    protected BasePageSearchValidate baseSearchValidate = new BasePageSearchValidate(driver);
    protected RedirectedPageValidate redirectedPageValidate = new RedirectedPageValidate(driver);


    @AfterTest
    public void clearCookiesAndLocalStorage(){
        if(CLEAR_COOKIES_AND_STORAGE){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterSuite()
    public void close(){
        if(HOLD_BROWSER_OPEN == true){
            driver.getWindowHandle();
        }
        driver.close();
    }
}
