package pos.tests.settings.currencies;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.settings.CreateCurrencyForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.settingspage.currenciespage.AllCurrenciesPage;
import pos.pageobjects.settingspage.currenciespage.CreateCurrencyPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateCurrencyTest extends BaseTest {
    @DataProvider(name = "currenciesData")
    public Object[][] getCurrencyData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//settings//Currencies.json");
        return data.stream()
                .map(d -> new Object[]{new CreateCurrencyForm(
                        d.get("currencyName"),
                        d.get("currencyCode"),
                        d.get("currencySymbol"),
                        d.get("currencyThousandSeparator"),
                        d.get("currencyDecimalSeparator")
                )})
                .toArray(Object[][]::new);
    }

    public CreateCurrencyPage fillForm(CreateCurrencyForm form) {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllCurrenciesPage allCurrenciesPage = dashboardPage.goToAllCurrenciesPage();
        CreateCurrencyPage createCurrencyPage = allCurrenciesPage.clickAddCurrencyButton();

        createCurrencyPage.enterCurrencyName(form.currencyName);
        createCurrencyPage.enterCurrencyCode(form.currencyCode);
        createCurrencyPage.enterCurrencySymbol(form.currencySymbol);
        createCurrencyPage.enterCurrencyThousandSeparator(form.currencyThousandSeparator);
        createCurrencyPage.enterCurrencyDecimalSeparator(form.currencyDecimalSeparator);

        return createCurrencyPage;
    }

    @Test(dataProvider = "currenciesData")
    public void createProductTest(CreateCurrencyForm form) {
        CreateCurrencyPage createCurrencyPage = this.fillForm(form);
        AllCurrenciesPage allCurrenciesPage = createCurrencyPage.clickCreateCurrencyButton();

        String expectSuccessMessage = allCurrenciesPage.getSuccessMessage();
        String actualSuccessMessage = "Currency Created!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }


}
