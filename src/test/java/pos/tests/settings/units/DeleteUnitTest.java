package pos.tests.settings.units;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.settingspage.unitspage.AllUnitsPage;
import pos.testcomponents.BaseTest;

public class DeleteUnitTest extends BaseTest {
    @Test
    public void deleteUnitTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllUnitsPage allUnitsPage = dashboardPage.goToAllUnitsPage();
        allUnitsPage.deleteUnit();

        String expectMessage = "Unit Deleted!";
        String actualMessage = allUnitsPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }

}
