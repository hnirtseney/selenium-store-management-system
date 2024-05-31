package pos.tests.settings.currencies;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.settingspage.currenciespage.AllCurrenciesPage;
import pos.pageobjects.settingspage.currenciespage.CreateCurrencyPage;
import pos.testcomponents.BaseTest;

public class UpdateCurrencyTest extends BaseTest {
    @Test
    public void updateCurrencyTest() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllCurrenciesPage allCurrenciesPage = dashboardPage.goToAllCurrenciesPage();
        CreateCurrencyPage createCurrencyPage = allCurrenciesPage.editCurrency();

        createCurrencyPage.enterCurrencyThousandSeparator(",");
        createCurrencyPage.enterCurrencyDecimalSeparator(".");

        allCurrenciesPage = createCurrencyPage.clickCreateCurrencyButton();

        String expectSuccessMessage = allCurrenciesPage.getSuccessMessage();
        String actualSuccessMessage = "Currency Updated!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }

}
