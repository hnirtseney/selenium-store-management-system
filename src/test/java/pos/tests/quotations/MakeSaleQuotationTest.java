package pos.tests.quotations;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.pageobjects.quotationspage.MakeSalePage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.testcomponents.BaseTest;

public class MakeSaleQuotationTest extends BaseTest {
    @Test(priority = 1)
    public void makeSalePaid() {

        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        AllQuotationsPage allQuotationsPage = dashboardPage.goToAllQuotationsPage();
        allQuotationsPage.expandSetting();

        MakeSalePage makeSalePage = allQuotationsPage.makeSaleQuotation();
        makeSalePage.clickTotalAmount();
        AllSalesPage allSalesPage = makeSalePage.clickCreateSale();

        String actualMessage = allSalesPage.getSuccessMessage();
        String expectSuccessMessage = "Sale Created!";
        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
//
//    @Test (priority = 2)
//    public void makeSalePartial() {
//
//        loginPage.goToLoginPage();
//        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
//        AllQuotationsPage allQuotationsPage = dashboardPage.goToAllQuotationsPage();
//        allQuotationsPage.expandSetting();
//
//        MakeSalePage makeSalePage = allQuotationsPage.makeSaleQuotation();
//        makeSalePage.clickTotalAmount();
//        AllSalesPage allSalesPage = makeSalePage.clickCreateSale();
//
//        String actualMessage =  allSalesPage.getSuccessMessage();
//        String expectSuccessMessage = "Sale Created!";
//        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
//    }
}
