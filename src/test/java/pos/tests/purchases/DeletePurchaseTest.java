package pos.tests.purchases;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasespage.AllPurchasesPage;
import pos.testcomponents.BaseTest;

public class DeletePurchaseTest extends BaseTest {
    @Test
    public void testDeletePurchase() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllPurchasesPage allPurchasesPage = dashboardPage.goToAllPurchasesPage();
        allPurchasesPage.deletePurchase();

        String actualMessage = allPurchasesPage.getSuccessMessage();
        String expectedMessage = "Purchase Deleted!";

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));

    }
}
