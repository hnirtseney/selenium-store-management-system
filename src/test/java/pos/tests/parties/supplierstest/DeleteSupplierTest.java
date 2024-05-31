package pos.tests.parties.supplierstest;

import org.testng.AssertJUnit;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.parties.supplierspage.SuppliersPage;
import pos.testcomponents.BaseTest;

public class DeleteSupplierTest extends BaseTest {
    public void deleteSupplierTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        SuppliersPage suppliersPage = dashboardPage.goToSuppliersPage();

        suppliersPage.deleteCustomer();

        String expectSuccessMessage = suppliersPage.getSuccessMessage();
        String actualSuccessMessage = "Supplier Deleted!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}