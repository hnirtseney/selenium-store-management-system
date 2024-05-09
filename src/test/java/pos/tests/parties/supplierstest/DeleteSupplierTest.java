package pos.tests.parties.supplierstest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.DashboardPage;
import pos.pageobjects.parties.supplierspage.SuppliersPage;
import pos.testcomponents.BaseTest;

public class DeleteSupplierTest extends BaseTest {
    @Test
    public void deleteSupplierTest() {
        // Login
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        SuppliersPage suppliersPage = dashboardPage.goToSuppliersPage();

        suppliersPage.deleteCustomer();

        String expectSuccessMessage = suppliersPage.getSuccessMessage();
        String actualSuccessMessage = "Supplier Deleted!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}