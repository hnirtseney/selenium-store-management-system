package pos.tests.quotations;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.testcomponents.BaseTest;

public class DeleteQuotationTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void deleteProduct(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllQuotationsPage allQuotationsPage = dashboardPage.goToAllQuotationsPage();
        allQuotationsPage.expandSetting();
        allQuotationsPage.deleteQuotation();

        String expectDeleteSuccessMessage = "Quotation Deleted!";
        String actualDeleteSuccessMessage = allQuotationsPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualDeleteSuccessMessage.equalsIgnoreCase(expectDeleteSuccessMessage));
    }

}
