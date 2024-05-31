package pos.tests.quotations;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.pageobjects.quotationspage.QuotationPage;
import pos.testcomponents.BaseTest;

public class UpdateQuotationTest extends BaseTest {
    @Test
    public void createValidQuotationTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllQuotationsPage allQuotationsPage = dashboardPage.goToAllQuotationsPage();

        allQuotationsPage.expandSetting();
        QuotationPage quotationPage = allQuotationsPage.editQuotation();
        quotationPage.selectQuotationStatus("Sent");
        AllQuotationsPage allQuotationsPageAfterUpdate = quotationPage.clickSubmitQuotation();
        String expectMessage = "Quotation Updated!";
        String actualMessage = allQuotationsPageAfterUpdate.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }
}
