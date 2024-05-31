package pos.tests.settings.units;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.settings.CreateUnitForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.settingspage.unitspage.AllUnitsPage;
import pos.pageobjects.settingspage.unitspage.CreateUnitPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateUnitTest extends BaseTest {
    @DataProvider(name = "unitData")
    public Object[][] getUnitData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//settings//Units.json");
        return data.stream()
                .map(d -> new Object[]{new CreateUnitForm(
                        d.get("unitName"),
                        d.get("unitShortName"),
                        d.get("unitOperator"),
                        d.get("unitOperatorValue")
                )})
                .toArray(Object[][]::new);
    }

    public CreateUnitPage fillForm(CreateUnitForm form) {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllUnitsPage allUnitsPage = dashboardPage.goToAllUnitsPage();
        CreateUnitPage createUnitPage = allUnitsPage.clickAddUnitButton();

        createUnitPage.enterUnitName(form.unitName);
        createUnitPage.enterShortName(form.unitShortName);
        createUnitPage.enterOperator(form.unitOperator);
        createUnitPage.enterOperationValue(form.unitOperatorValue);

        return createUnitPage;
    }

    @Test(dataProvider = "unitData")
    public void createProductTest(CreateUnitForm form) {
        CreateUnitPage createUnitPage = this.fillForm(form);
        AllUnitsPage allUnitsPage = createUnitPage.clickCreateUnitButton();

        String expectUpdateSuccessMessage = allUnitsPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Unit Created!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }


}
