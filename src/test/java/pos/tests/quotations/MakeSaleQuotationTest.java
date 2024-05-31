package pos.tests.quotations;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.pageobjects.quotationspage.MakeSalePage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.testcomponents.BaseTest;

public class MakeSaleQuotationTest extends BaseTest {
    @Test
    public void makeSalePaid() {
        DashboardPage dashboardPage = this.gotoDashboardPage();

        AllQuotationsPage allQuotationsPage = dashboardPage.goToAllQuotationsPage();
        allQuotationsPage.expandSetting();

        MakeSalePage makeSalePage = allQuotationsPage.makeSaleQuotation();
        makeSalePage.selectSaleStatus();
        makeSalePage.clickTotalAmount();
        AllSalesPage allSalesPage = makeSalePage.clickCreateSale();

        String actualMessage = allSalesPage.getSuccessMessage();
        String expectSuccessMessage = "Sale Created!";
        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
