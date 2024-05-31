package pos.tests.purchasereturns;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasereturnspage.AllPurchaseReturnsPage;
import pos.testcomponents.BaseTest;

public class VisiblePurchaseReturnsTableTest extends BaseTest {
    @Test
    public void visiblePurchaseReturnsTableTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllPurchaseReturnsPage allPurchaseReturnsPage = dashboardPage.goToAllPurchaseReturnsPage();
        allPurchaseReturnsPage.waitForElementToAppear(By.id("purchase-returns-table_wrapper"));

        Assert.assertTrue(allPurchaseReturnsPage.purchasesReturnTable.isDisplayed(), "Bảng danh sách purchases không hiển thị.");
    }
}
