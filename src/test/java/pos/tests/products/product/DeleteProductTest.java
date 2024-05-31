package pos.tests.products.product;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.productspage.AllProductsPage;
import pos.testcomponents.BaseTest;

public class DeleteProductTest extends BaseTest {
    @Test
    public void deleteProduct() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        AllProductsPage allProductsPage = dashboardPage.goToAllProductsPage();
        allProductsPage.deleteProduct();

        String expectMessage = "Product Deleted!";
        String actualMessage = allProductsPage.getSuccessMessage();
        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }

}
