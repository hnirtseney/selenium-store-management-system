package pos.tests.products.product;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.productspage.AllProductsPage;
import pos.pageobjects.productspage.ProductPage;
import pos.testcomponents.BaseTest;

public class UpdateProductTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void updateProductTest(String username, String password) {
        // Login
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);

        AllProductsPage allProductsPage;
        allProductsPage = dashboardPage.goToAllProductsPage();

        ProductPage productPage = allProductsPage.goToUpdateProductPage();
        productPage.inputProductStockAlert("10");

        allProductsPage = productPage.clickSubmitCreateUpdateProduct();

        String expectUpdateSuccessMessage = allProductsPage.getSuccessMessage();
        String actualUpdateSuccessMessage = "Product Updated!";

        AssertJUnit.assertTrue(actualUpdateSuccessMessage.equalsIgnoreCase(expectUpdateSuccessMessage));
    }

}
