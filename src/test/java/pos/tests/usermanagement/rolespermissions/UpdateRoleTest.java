package pos.tests.usermanagement.rolespermissions;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.usermanagementpage.rolespermissions.CreateRolePage;
import pos.pageobjects.usermanagementpage.rolespermissions.RolesAndPermissionsPage;
import pos.testcomponents.BaseTest;

public class UpdateRoleTest extends BaseTest {
    @Test
    public void updateRoleTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        RolesAndPermissionsPage rolesAndPermissionsPage = dashboardPage.goToRolesPermissionsPage();
        CreateRolePage updateRolesPage = rolesAndPermissionsPage.updateRole();
        updateRolesPage.giveAllPermissions();
        rolesAndPermissionsPage = updateRolesPage.clickCreateButton();

        String expectSuccessMessage = "Role Updated With Selected Permissions!";
        String actualSuccessMessage = rolesAndPermissionsPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }

}
