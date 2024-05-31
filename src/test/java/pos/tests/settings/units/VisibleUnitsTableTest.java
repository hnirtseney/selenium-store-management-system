package pos.tests.settings.units;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.settingspage.unitspage.AllUnitsPage;
import pos.testcomponents.BaseTest;

public class VisibleUnitsTableTest extends BaseTest {
    @Test
    public void visibleUnitsTableTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllUnitsPage allUnitsPage = dashboardPage.goToAllUnitsPage();
        allUnitsPage.waitForElementToAppear((By.id("data-table")));

        Assert.assertTrue(allUnitsPage.unitsTable.isDisplayed(), "Bảng danh sách units không hiển thị.");
    }
}
