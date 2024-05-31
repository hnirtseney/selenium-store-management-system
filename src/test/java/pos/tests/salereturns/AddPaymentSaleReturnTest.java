package pos.tests.salereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salereturnspage.AddPaymentSaleReturnPage;
import pos.pageobjects.salereturnspage.AllSaleReturnsPage;
import pos.testcomponents.BaseTest;

public class AddPaymentSaleReturnTest extends BaseTest {
    @Test
    public void addPaymentTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllSaleReturnsPage allSalesReturnPage = dashboardPage.goToAllSaleReturnsPage();
        AddPaymentSaleReturnPage addPaymentSaleReturnPage = allSalesReturnPage.clickAddPayment();

        addPaymentSaleReturnPage.clickGetTotalAmountButton();
        AllSaleReturnsPage allSalesPageAfterAddPayment = addPaymentSaleReturnPage.clickCreatePaymentButton();
        String expectMessage = "Sale Return Payment Created!";
        String actualMessage = allSalesPageAfterAddPayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }
}
