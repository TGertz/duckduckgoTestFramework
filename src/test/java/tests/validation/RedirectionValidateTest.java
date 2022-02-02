package tests.validation;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import static constants.Constant.Urls.DUCKDUCKGO_HOME_PAGE;

public class RedirectionValidateTest extends BaseTest {

    @Test
    public void redirectionValidateCheck() {
        basePage.open(DUCKDUCKGO_HOME_PAGE);
        redirectedPageValidate.redirectionToSearchResultsPage();
    }
}
