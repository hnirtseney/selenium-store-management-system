package pos.tests.sales;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.pageobjects.salespage.ShowPaymentPage;
import pos.testcomponents.BaseTest;

public class DeletePaymentTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void deletePaymentsTest(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);

        AllSalesPage allSalesPage = dashboardPage.goToAllSalesPage();
        ShowPaymentPage showPaymentPage = allSalesPage.clickShowPaymentPage();
        AllSalesPage allSalesPageAfterDeletePayment = showPaymentPage.clickDeleteButton();

        String expectMessage = "Sale Payment Deleted!";
        String actualMessage = allSalesPageAfterDeletePayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));

    }
}
