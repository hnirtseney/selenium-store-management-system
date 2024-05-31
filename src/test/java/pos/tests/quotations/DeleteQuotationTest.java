package pos.tests.quotations;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.testcomponents.BaseTest;

public class DeleteQuotationTest extends BaseTest {
    @Test
    public void deleteProduct() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllQuotationsPage allQuotationsPage = dashboardPage.goToAllQuotationsPage();
        allQuotationsPage.expandSetting();
        allQuotationsPage.deleteQuotation();

        String expectDeleteSuccessMessage = "Quotation Deleted!";
        String actualDeleteSuccessMessage = allQuotationsPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualDeleteSuccessMessage.equalsIgnoreCase(expectDeleteSuccessMessage));
    }

}
