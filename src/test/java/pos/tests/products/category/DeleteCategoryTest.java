package pos.tests.products.category;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.testcomponents.BaseTest;

public class DeleteCategoryTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void deleteCategory(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        CategoryPage categoryPage = dashboardPage.goToCategoryPage();
        categoryPage.deleteCategory();

        String deleteMessageExpect = "Product Category Deleted!";
        String deleteMessageActual = categoryPage.getDeleteSuccessMessage();
        AssertJUnit.assertTrue(deleteMessageActual.equalsIgnoreCase(deleteMessageExpect));
    }
}
