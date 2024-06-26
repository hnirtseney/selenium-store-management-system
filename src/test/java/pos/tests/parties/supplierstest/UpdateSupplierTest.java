package pos.tests.parties.supplierstest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.parties.supplierspage.CreateSupplierPage;
import pos.pageobjects.parties.supplierspage.SuppliersPage;
import pos.testcomponents.BaseTest;

public class UpdateSupplierTest extends BaseTest {

    @Test
    public void updateSupplierTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        SuppliersPage suppliersPage;
        suppliersPage = dashboardPage.goToSuppliersPage();
        CreateSupplierPage updateSupplier = suppliersPage.updateSupplierPage();
        suppliersPage = updateSupplier.clickSubmitCreateSupplier();

        String expectUpdateSuccessMessage = suppliersPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Supplier Updated!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }
}
