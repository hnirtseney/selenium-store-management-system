package pos.tests.usermanagement;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.usermanagementpage.AllUsersPage;
import pos.testcomponents.BaseTest;

public class DeleteUserTest extends BaseTest {
    @Test
    public void deleteUserTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllUsersPage allUsersPage = dashboardPage.goToAllUsersPage();
        allUsersPage.deleteUser();

        String expectMessage = "User Deleted!";
        String actualMessage = allUsersPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }

}
