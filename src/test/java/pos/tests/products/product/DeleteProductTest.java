package pos.tests.products.product;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.productspage.AllProductsPage;
import pos.testcomponents.BaseTest;

public class DeleteProductTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void deleteProduct(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        AllProductsPage allProductsPage = dashboardPage.goToAllProductsPage();
        allProductsPage.deleteProduct();

        String expectDeleteSuccessMessage = "Product Deleted!";
        String actualDeleteSuccessMessage = allProductsPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualDeleteSuccessMessage.equalsIgnoreCase(expectDeleteSuccessMessage));
    }

}
