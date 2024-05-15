// Đang có lỗi không lấy được locator Message

package pos.tests.quotations;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.pageobjects.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.pageobjects.quotationspage.QuotationPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateQuotationTest extends BaseTest {
    @DataProvider(name = "quotationsData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//quotations//Quotations1.json");
        return data.stream()
                .map(d -> new Object[] {
                        d.get("quotation_productCode"),
                        d.get("quotation_customer"),
                        d.get("quotation_quantity"),
                        d.get("quotation_tax"),
                        d.get("quotation_discount"),
                        d.get("quotation_shipping"),
                        d.get("quotation_status")
                })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "quotationsData")
    public void createProductTest(
            String quotation_productCode,
            String quotation_customer,
            String quotation_quantity,
            String quotation_tax,
            String quotation_discount,
            String quotation_shipping,
            String quotation_status
            ) {

        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        QuotationPage createQuotationPage = dashboardPage.goToCreateQuotationPage();

        createQuotationPage.inputProductCode(quotation_productCode);
        createQuotationPage.selectCustomer(quotation_customer);
        createQuotationPage.inputProductQuantity(quotation_quantity);
        createQuotationPage.inputQuantationTax(quotation_tax);
        createQuotationPage.inputQuotationDiscount(quotation_discount);
        createQuotationPage.inputQuotationShipping(quotation_shipping);
        createQuotationPage.selectQuotationStatus(quotation_status);

        AllQuotationsPage allQuotationsPage = createQuotationPage.clickSubmitQuotation();

        String expectSuccessMessage = allQuotationsPage.getSuccessMessage();
        String actualSuccessMessage = "Quotation Created!";

        AssertJUnit.assertTrue(actualSuccessMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
