package pos.tests.usermanagement.rolespermissions;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.usermanagementpage.rolespermissions.RolesAndPermissionsPage;
import pos.testcomponents.BaseTest;

public class VisibleRolesTable extends BaseTest {
    @Test
    public void visibleRolesTableTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        RolesAndPermissionsPage rolesAndPermissionsPage = dashboardPage.goToRolesPermissionsPage();
        rolesAndPermissionsPage.waitForElementToAppear(By.id("roles-table"));
        Assert.assertTrue(rolesAndPermissionsPage.tableRolesAndPermissions.isDisplayed(), "Bảng danh sách Users không hiển thị.");
    }
}