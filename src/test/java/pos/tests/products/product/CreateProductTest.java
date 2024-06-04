package pos.tests.products.product;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.products.ProductForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.productspage.AllProductsPage;
import pos.pageobjects.productspage.ProductPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateProductTest extends BaseTest {
    @DataProvider(name = "productData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//products//Product.json");
        return data.stream()
                .map(d -> new Object[]{new ProductForm(
                        d.get("product_name"),
                        d.get("product_code"),
                        d.get("product_category"),
                        d.get("product_barcode"),
                        d.get("product_cost"),
                        d.get("product_price"),
                        d.get("product_quantity"),
                        d.get("product_alert_quantity"),
                        d.get("product_tax"),
                        d.get("product_tax_type"),
                        d.get("product_unit"),
                        d.get("product_image")
                )})
                .toArray(Object[][]::new);
    }

    public ProductPage fillForm(ProductForm form) {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllProductsPage allProductsPage = dashboardPage.goToAllProductsPage();
        ProductPage createProductPage = allProductsPage.goToCreateProductPage();

        createProductPage.inputProductName(form.product_name);
        createProductPage.inputProductCode(form.product_code);
        createProductPage.selectCategory(form.product_category);
        createProductPage.selectBarcodeSymbology(form.product_barcode);
        createProductPage.inputProductCost(form.product_cost);
        createProductPage.inputProductPrice(form.product_price);
        createProductPage.inputProductQuantity(form.product_quantity);
        createProductPage.inputProductStockAlert(form.product_alert_quantity);
        createProductPage.inputProductOrderTax(form.product_tax);
        createProductPage.selectTaxType(form.product_tax_type);
        createProductPage.selectProductUnit(form.product_unit);
        createProductPage.uploadImageFile(form.product_image);

        return createProductPage;
    }

    @Test(
            dataProvider = "productData")
    public void createProductTest(ProductForm form) throws InterruptedException {
        ProductPage productPage = this.fillForm(form);
        Thread.sleep(3000);
        AllProductsPage allProductsPage = productPage.clickSubmitCreateUpdateProduct();

        String expectUpdateSuccessMessage = allProductsPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Product Created!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }
}
