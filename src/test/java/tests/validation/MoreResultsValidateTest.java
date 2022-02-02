package tests.validation;

import org.testng.annotations.Test;
import tests.base.BaseTest;
import static constants.Constant.Urls.DUCKDUCKGO_HOME_PAGE;

public class MoreResultsValidateTest extends BaseTest {

    @Test
    public void moreResultsValidateCheck() {
        basePage.open(DUCKDUCKGO_HOME_PAGE);
        redirectedPageValidate.moreResults();
        redirectedPageValidate.resultsCompare();
    }
}
