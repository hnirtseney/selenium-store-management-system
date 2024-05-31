package pos.tests.purchasereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasereturnspage.AllPurchaseReturnsPage;
import pos.testcomponents.BaseTest;

public class DeletePurchaseReturnTest extends BaseTest {

    @Test
    public void testDeletePurchase() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllPurchaseReturnsPage allPurchaseReturnsPage = dashboardPage.goToAllPurchaseReturnsPage();
        allPurchaseReturnsPage.deletePurchaseReturns();

        String actualMessage = allPurchaseReturnsPage.getSuccessMessage();
        String expectedMessage = "Purchase Return Deleted!";

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));

    }
}
