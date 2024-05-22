package pos.tests.purchases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasespage.AddPaymentPage;
import pos.pageobjects.purchasespage.AllPurchasesPage;
import pos.testcomponents.BaseTest;

public class AddPaymentTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void addPaymentTest(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllPurchasesPage allPurchasesPage = dashboardPage.goToAllPurchasesPage();
        AddPaymentPage addPaymentPage = allPurchasesPage.clickAddPayment();

        addPaymentPage.clickGetTotalAmountButton();
        AllPurchasesPage allPurchasesPageAfterAddPayment = addPaymentPage.clickCreatePaymentButton();
        String expectMessage = "Purchase Payment Created!";
        String actualMessage = allPurchasesPageAfterAddPayment.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }
}
