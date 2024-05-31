package pos.tests.purchasereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasereturnspage.AllPurchaseReturnsPage;
import pos.pageobjects.purchasereturnspage.ShowPaymentPurchaseReturnPage;
import pos.testcomponents.BaseTest;

public class DeletePaymentPurchaseReturnTest extends BaseTest {
    @Test
    public void deletePaymentsTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllPurchaseReturnsPage allPurchasesReturnPage = dashboardPage.goToAllPurchaseReturnsPage();
        ShowPaymentPurchaseReturnPage showPaymentPage = allPurchasesReturnPage.clickShowPayment();
        AllPurchaseReturnsPage allPurchasesPageAfterDeletePayment = showPaymentPage.clickDeleteButton();

        String expectMessage = "Purchase Payment Deleted!";
        String actualMessage = allPurchasesPageAfterDeletePayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));

    }
}
