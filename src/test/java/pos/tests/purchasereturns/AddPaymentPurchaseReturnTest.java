package pos.tests.purchasereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasereturnspage.AddPaymentPurchaseReturnPage;
import pos.pageobjects.purchasereturnspage.AllPurchaseReturnsPage;
import pos.testcomponents.BaseTest;

public class AddPaymentPurchaseReturnTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void addPaymentTest(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllPurchaseReturnsPage allPurchasesReturnPage = dashboardPage.goToAllPurchaseReturnsPage();
        AddPaymentPurchaseReturnPage addPaymentPurchaseReturnPage = allPurchasesReturnPage.clickAddPayment();

        addPaymentPurchaseReturnPage.clickGetTotalAmountButton();
        AllPurchaseReturnsPage allPurchasesPageAfterAddPayment = addPaymentPurchaseReturnPage.clickCreatePaymentButton();
        String expectMessage = "Purchase Return Payment Created!";
        String actualMessage = allPurchasesPageAfterAddPayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }
}
