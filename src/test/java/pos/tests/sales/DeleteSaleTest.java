package pos.tests.sales;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.testcomponents.BaseTest;

public class DeleteSaleTest extends BaseTest {

    @Test
    public void testDeleteSale() {
        DashboardPage dashboardPage = this.gotoDashboardPage();

        AllSalesPage allSalesPage = dashboardPage.goToAllSalesPage();
        allSalesPage.deleteSale();

        String actualMessage = allSalesPage.getSuccessMessage();
        String expectedMessage = "Sale Deleted!";

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));

    }
}
