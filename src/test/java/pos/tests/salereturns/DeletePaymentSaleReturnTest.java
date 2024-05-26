package pos.tests.salereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salereturnspage.AllSaleReturnsPage;
import pos.pageobjects.salereturnspage.ShowPaymentSaleReturnPage;
import pos.testcomponents.BaseTest;

public class DeletePaymentSaleReturnTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void deletePaymentsTest(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);

        AllSaleReturnsPage allSalesReturnPage = dashboardPage.goToAllSaleReturnsPage();
        ShowPaymentSaleReturnPage showPaymentPage = allSalesReturnPage.clickShowPayment();
        AllSaleReturnsPage allSalesPageAfterDeletePayment = showPaymentPage.clickDeleteButton();

        String expectMessage = "Sale Payment Deleted!";
        String actualMessage = allSalesPageAfterDeletePayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));

    }
}
