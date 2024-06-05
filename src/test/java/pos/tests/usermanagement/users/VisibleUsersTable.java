package pos.tests.usermanagement.users;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.usermanagementpage.users.AllUsersPage;
import pos.testcomponents.BaseTest;

public class VisibleUsersTable extends BaseTest {
    @Test
    public void visibleUsersTableTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllUsersPage allUsersPage = dashboardPage.goToAllUsersPage();
        allUsersPage.waitForElementToAppear((By.id("users-table")));
        Assert.assertTrue(allUsersPage.usersTable.isDisplayed(), "Bảng danh sách Users không hiển thị.");
    }
}