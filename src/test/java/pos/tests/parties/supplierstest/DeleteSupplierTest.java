package pos.tests.parties.supplierstest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.parties.supplierspage.SuppliersPage;
import pos.testcomponents.BaseTest;

public class DeleteSupplierTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void deleteSupplierTest(String username, String password) {
        // Login
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        SuppliersPage suppliersPage = dashboardPage.goToSuppliersPage();

        suppliersPage.deleteCustomer();

        String expectSuccessMessage = suppliersPage.getSuccessMessage();
        String actualSuccessMessage = "Supplier Deleted!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}