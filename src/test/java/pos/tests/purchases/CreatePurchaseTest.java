package pos.tests.purchases;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.purchases.CreatePurchaseForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.purchasespage.AllPurchasesPage;
import pos.pageobjects.purchasespage.CreatePurchasePage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreatePurchaseTest extends BaseTest {
    @DataProvider(name = "purchaseData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//purchases//Purchases.json");
        return data.stream()
                .map(d -> new Object[]{new CreatePurchaseForm(
                        d.get("productCode"),
                        d.get("supplierName"),
                        d.get("productQuantity"),
                        d.get("purchaseTax"),
                        d.get("purchaseDiscount"),
                        d.get("purchaseShipping"),
                        d.get("purchaseStatus"),
                        d.get("purchasePaymentMethod"),
                        d.get("purchaseAmountPaid")
                )})
                .toArray(Object[][]::new);
    }

    public CreatePurchasePage fillForm(CreatePurchaseForm form) throws InterruptedException {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CreatePurchasePage createPurchasePage = dashboardPage.goToCreatePurchasePage();

        createPurchasePage.inputProducts(form.productCode);
        createPurchasePage.selectSupplier(form.supplierName);
        createPurchasePage.inputQuantity(form.productQuantity);
        createPurchasePage.inputTaxPercentage(form.purchaseTax);
        createPurchasePage.inputDiscountPercentage(form.purchaseDiscount);
        createPurchasePage.inputShippingAmount(form.purchaseShipping);
        createPurchasePage.selectStatus(form.purchaseStatus);
        createPurchasePage.selectPaymentMethod(form.purchasePaymentMethod);
        createPurchasePage.inputAmount(form.purchaseAmountPaid);

        return createPurchasePage;
    }

    @Test(dataProvider = "purchaseData")
    public void createProductTest(CreatePurchaseForm form) throws InterruptedException {
        CreatePurchasePage createPurchasePage = this.fillForm(form);
        AllPurchasesPage allPurchasesPage = createPurchasePage.clickSubmitButton();

        String expectUpdateSuccessMessage = allPurchasesPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Purchase Created!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }
}
