package pos.tests.salereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salereturnspage.AllSaleReturnsPage;
import pos.testcomponents.BaseTest;

public class DeleteSaleReturnTest extends BaseTest {

    @Test
    public void testDeleteSale() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllSaleReturnsPage allSaleReturnsPage = dashboardPage.goToAllSaleReturnsPage();
        allSaleReturnsPage.deleteSaleReturns();

        String actualMessage = allSaleReturnsPage.getSuccessMessage();
        String expectedMessage = "Sale Return Deleted!";

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));

    }
}
