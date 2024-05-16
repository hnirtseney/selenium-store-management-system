package pos.tests.adjustments;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
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
                .map(d -> new Object[]{d.get("product_code"), d.get("adjustment_quantity"), d.get("adjustment_type")})
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "adjustmentData")
    public void createProductTest(String product_code, String adjustment_quantity, String adjustment_type) {
        // Login
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");

        // Navigate to Create Adjustment Page through Dashboard
        AdjustmentPage adjustmentPage = dashboardPage.goToAdjustmentPage();

        // Create Adjustment
        adjustmentPage.searchByProduct(product_code);
        adjustmentPage.fillAdjustmentQuantity(adjustment_quantity);
        adjustmentPage.chooseAdjustmentType(adjustment_type);
        AllAdjustmentsPage allAdjustmentsPage = adjustmentPage.clickCreateSuccess();

        String expectSuccessMessage = allAdjustmentsPage.getSuccessMessage();
        String actualSuccessMessage = "Adjustment Created!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }

}
