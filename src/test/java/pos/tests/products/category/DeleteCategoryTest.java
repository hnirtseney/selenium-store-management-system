package pos.tests.products.category;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.testcomponents.BaseTest;

public class DeleteCategoryTest extends BaseTest {
    @Test(
            groups = {"ProductsTest"}
    )
    public void deleteCategory() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CategoryPage categoryPage = dashboardPage.goToCategoryPage();
        categoryPage.deleteCategory();

        String deleteMessageExpect = "Product Category Deleted!";
        String deleteMessageActual = categoryPage.getDeleteSuccessMessage();
        AssertJUnit.assertTrue(deleteMessageActual.equalsIgnoreCase(deleteMessageExpect));
    }
}
