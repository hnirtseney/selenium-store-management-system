package pos.tests.adjustments;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.adjustments.AdjustmentForm;
import pos.pageobjects.adjustmentspage.AdjustmentPage;
import pos.pageobjects.adjustmentspage.AllAdjustmentsPage;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateAdjustmentTest extends BaseTest {
    @DataProvider(name = "adjustmentData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//adjustments//Adjustment.json");
        return data.stream()
                .map(d -> new Object[]{new AdjustmentForm(
                        d.get("product_code"),
                        d.get("adjustment_quantity"),
                        d.get("adjustment_type")
                )})
                .toArray(Object[][]::new);
    }

    public AdjustmentPage fillForm(AdjustmentForm form) {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AdjustmentPage createAdjustmentPage = dashboardPage.goToAdjustmentPage();
        createAdjustmentPage.searchByProduct(form.product_code);
        createAdjustmentPage.fillAdjustmentQuantity(form.adjustment_quantity);
        createAdjustmentPage.chooseAdjustmentType(form.adjustment_type);
        return createAdjustmentPage;
    }


    @Test(dataProvider = "adjustmentData")
    public void createAdjustmenTest(AdjustmentForm form) {
        AdjustmentPage createAdjustmentPage = this.fillForm(form);
        AllAdjustmentsPage allAdjustmentsPage = createAdjustmentPage.clickCreateSuccess();

        String expectSuccessMessage = allAdjustmentsPage.getSuccessMessage();
        String actualSuccessMessage = "Adjustment Created!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }

}
