package pos.tests.parties.supplierstest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.parties.supplierspage.SuppliersPage;
import pos.testcomponents.BaseTest;

public class VisibleSupplierTableTest extends BaseTest {
    @Test
    public void visibleSupplierTableTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        SuppliersPage suppliersPage = dashboardPage.goToSuppliersPage();
        suppliersPage.waitForElementToAppear(By.id("suppliers-table"));
        Assert.assertTrue(suppliersPage.supplierTable.isDisplayed(), "Bảng danh sách nhà cung cấp không hiển thị.");
    }
}
