package pos.tests.settings.currencies;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.settingspage.currenciespage.AllCurrenciesPage;
import pos.testcomponents.BaseTest;

public class VisibleCurrenciesTableTest extends BaseTest {
    @Test
    public void visibleCurrenciesTableTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllCurrenciesPage allCurrenciesPage = dashboardPage.goToAllCurrenciesPage();
        allCurrenciesPage.waitForElementToAppear((By.id("currency-table")));
        Assert.assertTrue(allCurrenciesPage.currenciesTable.isDisplayed(), "Bảng danh sách currencies không hiển thị.");
    }
}