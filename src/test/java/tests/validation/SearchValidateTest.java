package tests.validation;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import static constants.Constant.Urls.DUCKDUCKGO_HOME_PAGE;

public class SearchValidateTest extends BaseTest {

    @Test
    public void searchValidateCheck() {
        basePage.open(DUCKDUCKGO_HOME_PAGE);
        baseSearchValidate.inputValidate();
    }
}
