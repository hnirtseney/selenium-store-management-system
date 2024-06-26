package pos.tests.usermanagement.rolespermissions;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.usermanagementpage.rolespermissions.RolesAndPermissionsPage;
import pos.testcomponents.BaseTest;

public class DeleteRoleTest extends BaseTest {
    @Test
    public void deleteRoleTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        RolesAndPermissionsPage rolesAndPermissionsPage = dashboardPage.goToRolesPermissionsPage();
        rolesAndPermissionsPage.deleteRole();

        String expectMessage = "Role Deleted!";
        String actualMessage = rolesAndPermissionsPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }
}
