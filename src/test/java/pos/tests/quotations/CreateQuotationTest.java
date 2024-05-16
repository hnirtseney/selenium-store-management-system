// Đang có lỗi không lấy được locator Message

package pos.tests.quotations;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.quotationspage.AllQuotationsPage;
import pos.pageobjects.quotationspage.QuotationPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateQuotationTest extends BaseTest {
    @DataProvider(name = "quotationsInvalidData")
    public Object[][] getInvalidQuotationData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//quotations//QuotationsInvalid.json");
        return data.stream()
                .map(d -> new Object[]{
                        d.get("quotation_productCode"),
                        d.get("quotation_customer"),
                        d.get("quotation_quantity"),
                        d.get("quotation_tax"),
                        d.get("quotation_discount"),
                        d.get("quotation_shipping"),
                        d.get("quotation_status"),
                        d.get("quotation_message")
                })
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "quotationsValidData")
    public Object[][] getValidQuotationData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//quotations//QuotationsValid.json");
        return data.stream()
                .map(d -> new Object[]{
                        d.get("quotation_productCode"),
                        d.get("quotation_customer"),
                        d.get("quotation_quantity"),
                        d.get("quotation_tax"),
                        d.get("quotation_discount"),
                        d.get("quotation_shipping"),
                        d.get("quotation_status"),
                        d.get("quotation_message")
                })
                .toArray(Object[][]::new);
    }

    @Test(dataProvider = "quotationsInvalidData")
    public void createInvalidQuotationTest(
            String quotation_productCode,
            String quotation_customer,
            String quotation_quantity,
            String quotation_tax,
            String quotation_discount,
            String quotation_shipping,
            String quotation_status,
            String quotation_message
    ) {

        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        QuotationPage createQuotationPage = dashboardPage.goToCreateQuotationPage();

        createQuotationPage.inputProductCode(quotation_productCode);
        createQuotationPage.selectCustomer(quotation_customer);
        createQuotationPage.inputProductQuantity(quotation_quantity);
        createQuotationPage.inputQuotationTax(quotation_tax);
        createQuotationPage.inputQuotationDiscount(quotation_discount);
        createQuotationPage.inputQuotationShipping(quotation_shipping);
        createQuotationPage.selectQuotationStatus(quotation_status);

        createQuotationPage.clickSubmitQuotation();
        String actualMessage = createQuotationPage.getValidationMessage();

        Assert.assertEquals(actualMessage, quotation_message);
    }

    @Test(dataProvider = "quotationsValidData")
    public void createValidQuotationTest(
            String quotation_productCode,
            String quotation_customer,
            String quotation_quantity,
            String quotation_tax,
            String quotation_discount,
            String quotation_shipping,
            String quotation_status,
            String quotation_message
    ) {

        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        QuotationPage createQuotationPage = dashboardPage.goToCreateQuotationPage();

        createQuotationPage.inputProductCode(quotation_productCode);
        createQuotationPage.selectCustomer(quotation_customer);
        createQuotationPage.inputProductQuantity(quotation_quantity);
        createQuotationPage.inputQuotationTax(quotation_tax);
        createQuotationPage.inputQuotationDiscount(quotation_discount);
        createQuotationPage.inputQuotationShipping(quotation_shipping);
        createQuotationPage.selectQuotationStatus(quotation_status);

        AllQuotationsPage allQuotationsPage = createQuotationPage.clickSubmitQuotation();
        String actualMessage = allQuotationsPage.getSuccessMessage();

        Assert.assertEquals(actualMessage, quotation_message);
    }


}
