package pos.tests.quotations;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.testcomponents.BaseTest;

public class VisibleQuotationTest extends BaseTest {
    @Test
    public void visibleCategoriesTable() {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        AllQuotationsPage allQuotationsPage = dashboardPage.goToAllQuotationsPage();
        allQuotationsPage.waitForElementToAppear(By.id("sales-table_wrapper"));

        Assert.assertTrue(allQuotationsPage.allQuotationsTable.isDisplayed(), "Bảng danh sách categories không hiển thị.");
    }
}
