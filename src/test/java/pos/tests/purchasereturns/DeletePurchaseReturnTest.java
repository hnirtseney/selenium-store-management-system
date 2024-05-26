package pos.tests.purchasereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasereturnspage.AllPurchaseReturnsPage;
import pos.testcomponents.BaseTest;

public class DeletePurchaseReturnTest extends BaseTest {

    @Test(dataProvider = "testAccount")
    public void testDeletePurchase(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllPurchaseReturnsPage allPurchaseReturnsPage = dashboardPage.goToAllPurchaseReturnsPage();
        allPurchaseReturnsPage.deletePurchaseReturns();

        String actualMessage = allPurchaseReturnsPage.getSuccessMessage();
        String expectedMessage = "Purchase Return Deleted!";

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));

    }
}
