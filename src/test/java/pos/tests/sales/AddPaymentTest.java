package pos.tests.sales;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salespage.AddPaymentPage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.testcomponents.BaseTest;

public class AddPaymentTest extends BaseTest {
    @Test
    public void addPaymentTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();

        AllSalesPage allSalesPage = dashboardPage.goToAllSalesPage();
        AddPaymentPage addPaymentPage = allSalesPage.clickAddPaymentButton();

        addPaymentPage.clickGetTotalAmountButton();
        AllSalesPage allSalesPageAfterAddPayment = addPaymentPage.clickCreatePaymentButton();
        String expectMessage = "Sale Payment Created!";
        String actualMessage = allSalesPageAfterAddPayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }
}
