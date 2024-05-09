package pos.tests.adjustments;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.adjustmentspage.AllAdjustmentsPage;
import pos.testcomponents.BaseTest;

public class DeleteAdjustmentTest extends BaseTest {
    @Test
    public void deleteAdjustmentTest() {
        // Login
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        AllAdjustmentsPage allAdjustmentsPage = dashboardPage.goToAllAdjustmentsPage();
        allAdjustmentsPage.deleteAdjustment();

        String expectSuccessMessage = allAdjustmentsPage.getSuccessMessage();
        String actualSuccessMessage = "Adjustment Deleted!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }

}
