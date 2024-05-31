package pos.tests.purchases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasespage.AllPurchasesPage;
import pos.testcomponents.BaseTest;

public class VisiblePurchasesTableTest extends BaseTest {
    @Test
    public void visibleCategoriesTable() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllPurchasesPage allPurchasesPage = dashboardPage.goToAllPurchasesPage();
        allPurchasesPage.waitForElementToAppear(By.id("purchases-table_wrapper"));

        Assert.assertTrue(allPurchasesPage.purchasesTable.isDisplayed(), "Bảng danh sách purchases không hiển thị.");
    }
}
