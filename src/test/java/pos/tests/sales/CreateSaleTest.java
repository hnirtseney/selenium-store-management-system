package pos.tests.sales;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.sales.CreateSaleForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salespage.AllSalesPage;
import pos.pageobjects.salespage.CreateSalePage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateSaleTest extends BaseTest {
    @DataProvider(name = "saleData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//sales//Sales.json");
        return data.stream()
                .map(d -> new Object[]{new CreateSaleForm(
                        d.get("productCode"),
                        d.get("customerName"),
                        d.get("productQuantity"),
                        d.get("saleTax"),
                        d.get("saleDiscount"),
                        d.get("saleShipping"),
                        d.get("saleStatus"),
                        d.get("salePaymentMethod"),
                        d.get("saleAmountReceived")
                )})
                .toArray(Object[][]::new);
    }

    public CreateSalePage fillForm(CreateSaleForm form) throws InterruptedException {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CreateSalePage createSalePage = dashboardPage.goToCreateSalePage();

        createSalePage.inputProducts(form.productCode);
        createSalePage.selectCustomer(form.customerName);
        createSalePage.inputQuantity(form.productQuantity);
        createSalePage.inputTaxPercentage(form.saleTax);
        createSalePage.inputDiscountPercentage(form.saleDiscount);
        createSalePage.inputShippingAmount(form.saleShipping);
        createSalePage.selectStatus(form.saleStatus);
        createSalePage.selectPaymentMethod(form.salePaymentMethod);
        createSalePage.inputAmount(form.saleAmountReceived);

        return createSalePage;
    }

    @Test(dataProvider = "saleData")
    public void createProductTest(CreateSaleForm form) throws InterruptedException {
        CreateSalePage createSalePage = this.fillForm(form);
        AllSalesPage allSalesPage = createSalePage.clickSubmitButton();

        String expectUpdateSuccessMessage = allSalesPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Sale Created!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }
}
