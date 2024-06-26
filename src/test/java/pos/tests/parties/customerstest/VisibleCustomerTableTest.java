package pos.tests.parties.customerstest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.parties.customerspage.CustomersPage;
import pos.testcomponents.BaseTest;

public class VisibleCustomerTableTest extends BaseTest {
    @Test
    public void visibleCustomerTableTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CustomersPage customersPage = dashboardPage.goToCustomersPage();

        customersPage.waitForElementToAppear(By.id("customers-table"));

        Assert.assertTrue(customersPage.customersTable.isDisplayed(), "Bảng danh sách khách hàng không hiển thị.");
    }
}
