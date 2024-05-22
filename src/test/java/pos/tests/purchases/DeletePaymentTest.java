package pos.tests.purchases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasespage.AllPurchasesPage;
import pos.pageobjects.purchasespage.ShowPaymentPage;
import pos.testcomponents.BaseTest;

public class DeletePaymentTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void deletePaymentsTest(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);

        AllPurchasesPage allPurchasesPage = dashboardPage.goToAllPurchasesPage();
        ShowPaymentPage showPaymentPage = allPurchasesPage.clickShowPayment();
        AllPurchasesPage allPurchasesPageAfterDeletePayment = showPaymentPage.clickDeleteButton();

        String expectMessage = "Purchase Payment Deleted!";
        String actualMessage = allPurchasesPageAfterDeletePayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));

    }
}
