package pos.tests.products.category;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.testcomponents.BaseTest;

public class DeleteCategoryTest extends BaseTest {
	@Test
	public void deleteCategory() {
		loginPage.goToLoginPage();
		DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
		CategoryPage categoryPage = dashboardPage.goToCategoryPage();
		categoryPage.deleteCategory();

		String deleteMessageExpect = "Product Category Deleted!";
		String deleteMessageActual = categoryPage.getDeleteSuccessMessage();
		AssertJUnit.assertTrue(deleteMessageActual.equalsIgnoreCase(deleteMessageExpect));
	}

}
