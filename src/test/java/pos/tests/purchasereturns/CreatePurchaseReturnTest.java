package pos.tests.purchasereturns;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.CreatePurchaseReturnForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasereturnspage.AllPurchaseReturnsPage;
import pos.pageobjects.purchasereturnspage.CreatePurchaseReturnPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreatePurchaseReturnTest extends BaseTest {
    @DataProvider(name = "purchaseData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//purchasereturns//PurchaseReturns.json");
        return data.stream()
                .map(d -> new Object[]{new CreatePurchaseReturnForm(
                        d.get("productCode"),
                        d.get("supplierName"),
                        d.get("productQuantity"),
                        d.get("purchaseReturnTax"),
                        d.get("purchaseReturnDiscount"),
                        d.get("purchaseReturnShipping"),
                        d.get("purchaseReturnStatus"),
                        d.get("purchaseReturnPaymentMethod"),
                        d.get("purchaseReturnAmountPaid")
                )})
                .toArray(Object[][]::new);
    }

    public CreatePurchaseReturnPage fillForm(CreatePurchaseReturnForm form) throws InterruptedException {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        CreatePurchaseReturnPage createPurchaseReturnPage = dashboardPage.goToCreatePurchaseReturnPage();

        createPurchaseReturnPage.inputProducts(form.productCode);
        createPurchaseReturnPage.selectSupplier(form.supplierName);
        createPurchaseReturnPage.inputQuantity(form.productQuantity);
        createPurchaseReturnPage.inputTaxPercentage(form.purchaseReturnTax);
        createPurchaseReturnPage.inputDiscountPercentage(form.purchaseReturnDiscount);
        createPurchaseReturnPage.inputShippingAmount(form.purchaseReturnShipping);
        createPurchaseReturnPage.selectStatus(form.purchaseReturnStatus);
        createPurchaseReturnPage.selectPaymentMethod(form.purchaseReturnPaymentMethod);
        createPurchaseReturnPage.inputAmount(form.purchaseReturnAmountPaid);

        return createPurchaseReturnPage;
    }

    @Test(dataProvider = "purchaseData")
    public void createPurchaseReturnTest(CreatePurchaseReturnForm form) throws InterruptedException {
        CreatePurchaseReturnPage createPurchaseReturnPage = this.fillForm(form);
        AllPurchaseReturnsPage allPurchaseReturnsPage = createPurchaseReturnPage.clickSubmitButton();

        String expectUpdateSuccessMessage = allPurchaseReturnsPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Purchase Return Created!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }
}
