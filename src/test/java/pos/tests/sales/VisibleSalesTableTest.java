package pos.tests.sales;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.testcomponents.BaseTest;

public class VisibleSalesTableTest extends BaseTest {
    @Test
    public void visibleCategoriesTable() {
        DashboardPage dashboardPage = this.gotoDashboardPage();

        AllSalesPage allSalesPage = dashboardPage.goToAllSalesPage();
        allSalesPage.waitForElementToAppear(By.id("sales-table"));

        Assert.assertTrue(allSalesPage.salesTable.isDisplayed(), "Bảng danh sách sales không hiển thị.");
    }
}
