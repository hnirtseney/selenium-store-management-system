package pos.tests.usermanagement.users;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.usermanagementpage.users.AllUsersPage;
import pos.pageobjects.usermanagementpage.users.CreateUserPage;
import pos.testcomponents.BaseTest;

public class UpdateUserTest extends BaseTest {
    @Test
    public void updateUserTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllUsersPage allUsersPage = dashboardPage.goToAllUsersPage();
        String role = allUsersPage.getUserRole();
        CreateUserPage createUserPage = allUsersPage.editUser();

        createUserPage.selectUserStatus("Active");
        allUsersPage = createUserPage.clickSubmitButton();

        String expectSuccessMessage = "User Updated & Assigned '" + role + "' Role!";
        String actualSuccessMessage = allUsersPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }

}
