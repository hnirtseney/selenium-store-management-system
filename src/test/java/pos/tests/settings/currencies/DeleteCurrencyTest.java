package pos.tests.settings.currencies;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.settingspage.currenciespage.AllCurrenciesPage;
import pos.testcomponents.BaseTest;

public class DeleteCurrencyTest extends BaseTest {
    @Test
    public void deleteCurrencyTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllCurrenciesPage allCurrenciesPage = dashboardPage.goToAllCurrenciesPage();
        allCurrenciesPage.deleteCurrency();

        String expectMessage = "Currency Deleted!";
        String actualMessage = allCurrenciesPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }

}
