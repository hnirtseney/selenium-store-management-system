package pos.tests.quotations;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.QuotationForm;
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
                .map(d -> new Object[]{new QuotationForm(
                        d.get("quotation_productCode"),
                        d.get("quotation_customer"),
                        d.get("quotation_quantity"),
                        d.get("quotation_tax"),
                        d.get("quotation_discount"),
                        d.get("quotation_shipping"),
                        d.get("quotation_status"),
                        d.get("quotation_message")
                )})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "quotationsValidData")
    public Object[][] getValidQuotationData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//quotations//QuotationsValid.json");
        return data.stream()
                .map(d -> new Object[]{new QuotationForm(
                        d.get("quotation_productCode"),
                        d.get("quotation_customer"),
                        d.get("quotation_quantity"),
                        d.get("quotation_tax"),
                        d.get("quotation_discount"),
                        d.get("quotation_shipping"),
                        d.get("quotation_status"),
                        d.get("quotation_message")
                )})
                .toArray(Object[][]::new);
    }

    public QuotationPage fillForm(QuotationForm form) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        QuotationPage createQuotationPage = dashboardPage.goToCreateQuotationPage();

        createQuotationPage.inputProductCode(form.quotation_productCode);
        createQuotationPage.selectCustomer(form.quotation_customer);
        createQuotationPage.inputProductQuantity(form.quotation_quantity);
        createQuotationPage.inputQuotationTax(form.quotation_tax);
        createQuotationPage.inputQuotationDiscount(form.quotation_discount);
        createQuotationPage.inputQuotationShipping(form.quotation_shipping);
        createQuotationPage.selectQuotationStatus(form.quotation_status);
        return createQuotationPage;
    }

    @Test(dataProvider = "quotationsInvalidData")
    public void createInvalidQuotationTest(QuotationForm form) {
        QuotationPage createQuotationPage = this.fillForm(form);
        createQuotationPage.clickSubmitQuotation();
        String actualMessage = createQuotationPage.getValidationMessage();
        Assert.assertEquals(actualMessage, form.quotation_message);
    }

    @Test(dataProvider = "quotationsValidData")
    public void createValidQuotationTest(QuotationForm form) {
        QuotationPage createQuotationPage = this.fillForm(form);
        AllQuotationsPage allQuotationsPage = createQuotationPage.clickSubmitQuotation();
        String actualMessage = allQuotationsPage.getSuccessMessage();
        Assert.assertEquals(actualMessage, form.quotation_message);
    }


}
