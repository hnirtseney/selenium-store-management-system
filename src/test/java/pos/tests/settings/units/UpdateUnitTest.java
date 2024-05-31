package pos.tests.settings.units;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.settingspage.unitspage.AllUnitsPage;
import pos.pageobjects.settingspage.unitspage.CreateUnitPage;
import pos.testcomponents.BaseTest;

public class UpdateUnitTest extends BaseTest {
    @Test
    public void updateUnitTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllUnitsPage allUnitsPage = dashboardPage.goToAllUnitsPage();
        CreateUnitPage createUnitPage = allUnitsPage.editUnit();

        createUnitPage.enterOperator("*");
        createUnitPage.enterOperationValue("1");

        allUnitsPage = createUnitPage.clickCreateUnitButton();

        String expectUpdateSuccessMessage = allUnitsPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Unit Updated!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }

}
