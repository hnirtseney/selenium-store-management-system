package pos.tests.salereturns;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salereturnspage.AllSaleReturnsPage;
import pos.testcomponents.BaseTest;

public class VisibleSaleReturnsTableTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void visibleSaleReturnsTableTest(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllSaleReturnsPage allSaleReturnsPage = dashboardPage.goToAllSaleReturnsPage();
        allSaleReturnsPage.waitForElementToAppear(By.id("sale-returns-table_wrapper"));

        Assert.assertTrue(allSaleReturnsPage.salesReturnTable.isDisplayed(), "Bảng danh sách sales không hiển thị.");
    }
}
