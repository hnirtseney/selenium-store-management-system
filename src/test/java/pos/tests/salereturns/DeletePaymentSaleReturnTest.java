package pos.tests.salereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salereturnspage.AllSaleReturnsPage;
import pos.pageobjects.salereturnspage.ShowPaymentSaleReturnPage;
import pos.testcomponents.BaseTest;

public class DeletePaymentSaleReturnTest extends BaseTest {
    @Test
    public void deletePaymentsTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();

        AllSaleReturnsPage allSalesReturnPage = dashboardPage.goToAllSaleReturnsPage();
        ShowPaymentSaleReturnPage showPaymentPage = allSalesReturnPage.clickShowPayment();
        AllSaleReturnsPage allSalesPageAfterDeletePayment = showPaymentPage.clickDeleteButton();

        String expectMessage = "Sale Return Payment Deleted!";
        String actualMessage = allSalesPageAfterDeletePayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));

    }
}
