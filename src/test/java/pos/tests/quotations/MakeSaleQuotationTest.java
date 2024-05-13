package pos.tests.quotations;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.pageobjects.quotationspage.QuotationPage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.testcomponents.BaseTest;

public class MakeSaleQuotationTest extends BaseTest {
    @Test
    public void makeSaleQuotation() {

        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        AllQuotationsPage allQuotationsPage = dashboardPage.goToAllQuotationsPage();
        allQuotationsPage.expandSetting();

        QuotationPage makeSaleQuotationPage = allQuotationsPage.makeSaleQuotation();
        makeSaleQuotationPage.clickTotalAmount();
        AllSalesPage allSalesPage = makeSaleQuotationPage.clickCreateSale();

        String actualMessage =  allSalesPage.getSuccessMessage();
        String expectSuccessMessage = "Sale Created!";
        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
