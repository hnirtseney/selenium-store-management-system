package pos.tests.purchases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasespage.AllPurchasesPage;
import pos.testcomponents.BaseTest;

public class DeletePurchaseTest extends BaseTest {

    @Test(dataProvider = "testAccount")
    public void testDeletePurchase(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllPurchasesPage allPurchasesPage = dashboardPage.goToAllPurchasesPage();
        allPurchasesPage.deletePurchase();

        String actualMessage = allPurchasesPage.getSuccessMessage();
        String expectedMessage = "Purchase Deleted!";

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));

    }
}
