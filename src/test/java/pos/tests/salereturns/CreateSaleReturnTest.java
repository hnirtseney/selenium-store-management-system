package pos.tests.salereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.CreateSaleReturnForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.salereturnspage.AllSaleReturnsPage;
import pos.pageobjects.salereturnspage.CreateSaleReturnPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateSaleReturnTest extends BaseTest {
    @DataProvider(name = "saleData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//salereturns//SaleReturns.json");
        return data.stream()
                .map(d -> new Object[]{new CreateSaleReturnForm(
                        d.get("productCode"),
                        d.get("customerName"),
                        d.get("productQuantity"),
                        d.get("saleReturnTax"),
                        d.get("saleReturnDiscount"),
                        d.get("saleReturnShipping"),
                        d.get("saleReturnStatus"),
                        d.get("saleReturnPaymentMethod"),
                        d.get("saleReturnAmountReceived")
                )})
                .toArray(Object[][]::new);
    }

    public CreateSaleReturnPage fillForm(CreateSaleReturnForm form) throws InterruptedException {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        CreateSaleReturnPage createSaleReturnPage = dashboardPage.goToCreateSaleReturnPage();

        createSaleReturnPage.inputProducts(form.productCode);
        createSaleReturnPage.selectCustomer(form.customerName);
        createSaleReturnPage.inputQuantity(form.productQuantity);
        createSaleReturnPage.inputTaxPercentage(form.saleReturnTax);
        createSaleReturnPage.inputDiscountPercentage(form.saleReturnDiscount);
        createSaleReturnPage.inputShippingAmount(form.saleReturnShipping);
        createSaleReturnPage.selectStatus(form.saleReturnStatus);
        createSaleReturnPage.selectPaymentMethod(form.saleReturnPaymentMethod);
        createSaleReturnPage.inputAmount(form.saleReturnAmountReceived);

        return createSaleReturnPage;
    }

    @Test(dataProvider = "saleData")
    public void createSaleReturnTest(CreateSaleReturnForm form) throws InterruptedException {
        CreateSaleReturnPage createSaleReturnPage = this.fillForm(form);
        AllSaleReturnsPage allSaleReturnsPage = createSaleReturnPage.clickSubmitButton();

        String expectUpdateSuccessMessage = allSaleReturnsPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Sale Return Created!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }
}
