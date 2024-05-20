package pos.tests.sales;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.testcomponents.BaseTest;

public class VisibleSalesTableTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void visibleCategoriesTable(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllSalesPage allSalesPage = dashboardPage.goToAllSalesPage();
        allSalesPage.waitForElementToAppear(By.id("sales-table"));

        Assert.assertTrue(allSalesPage.salesTable.isDisplayed(), "Bảng danh sách sales không hiển thị.");
    }
}
