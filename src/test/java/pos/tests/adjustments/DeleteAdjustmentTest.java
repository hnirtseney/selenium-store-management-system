package pos.tests.adjustments;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.adjustmentspage.AllAdjustmentsPage;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.testcomponents.BaseTest;

public class DeleteAdjustmentTest extends BaseTest {
    @Test
    public void deleteAdjustmentTest() {
        // Login
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllAdjustmentsPage allAdjustmentsPage = dashboardPage.goToAllAdjustmentsPage();
        allAdjustmentsPage.deleteAdjustment();

        String expectSuccessMessage = allAdjustmentsPage.getSuccessMessage();
        String actualSuccessMessage = "Adjustment Deleted!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }

}