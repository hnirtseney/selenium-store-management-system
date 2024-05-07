package pos.tests.products.product;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.productspage.AllProductsPage;
import pos.testcomponents.BaseTest;

public class DeleteProductTest extends BaseTest {
    @Test
    public void deleteProduct() {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        AllProductsPage allProductsPage = dashboardPage.goToAllProductsPage();
        allProductsPage.deleteProduct();

        String expectDeleteSuccessMessage = "Product Deleted!";
        String actualDeleteSuccessMessage = allProductsPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualDeleteSuccessMessage.equalsIgnoreCase(expectDeleteSuccessMessage));
    }

}
