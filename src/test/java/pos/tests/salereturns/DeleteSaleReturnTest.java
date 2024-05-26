package pos.tests.salereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salereturnspage.AllSaleReturnsPage;
import pos.testcomponents.BaseTest;

public class DeleteSaleReturnTest extends BaseTest {

    @Test(dataProvider = "testAccount")
    public void testDeleteSale(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllSaleReturnsPage allSaleReturnsPage = dashboardPage.goToAllSaleReturnsPage();
        allSaleReturnsPage.deleteSaleReturns();

        String actualMessage = allSaleReturnsPage.getSuccessMessage();
        String expectedMessage = "Sale Return Deleted!";

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage));

    }
}
