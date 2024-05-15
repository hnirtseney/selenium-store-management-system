//1. Bổ sung Verify qua Message

package pos.tests.products.category;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateCategoryTest extends BaseTest {
	@DataProvider(name = "categoryData")
	public Object[][] getCategoryData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//pos//data//products//Category.json");
		return data.stream()
				.map(d -> new Object[] { d.get("category_code"), d.get("category_name") })
				.toArray(Object[][]::new);
	}

	@DataProvider(name = "singleCategoryData")
	public Object[][] getSingleCategoryData() throws IOException {
		List<HashMap<String, String>> data = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//pos//data//products//Category.json");
		return new Object[][] { { data.get(0).get("category_code"), data.get(0).get("category_name") } };
	}

	@Test(
//			dataProvider = "categoryData",
			dataProvider = "singleCategoryData",
			priority = 1)
	public void createSuccessCategoryTest(String category_code, String category_name) {
		// Login
		loginPage.goToLoginPage();
		DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");

		// Navigate to Category Page through Dashboard
		CategoryPage categoryPage = dashboardPage.goToCategoryPage();

		// Create Category
		categoryPage.openAddCategoryModal();
		categoryPage.inputCategoryCode(category_code);
		categoryPage.inputCategoryName(category_name);
		categoryPage.createCategory();

		String expectMessage = "Product Category Created!";
		String actualMessage = categoryPage.getSuccessMessage();

		AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
	}

	@Test (
			dataProvider = "singleCategoryData",
			priority = 2)
	public void createFailedCategorySuccess(String category_code, String category_name) {
		loginPage.goToLoginPage();
		DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");

		// Navigate to Category Page through Dashboard
		CategoryPage categoryPage = dashboardPage.goToCategoryPage();

		// Create Category
		categoryPage.openAddCategoryModal();
		categoryPage.inputCategoryCode(category_code);
		categoryPage.inputCategoryName(category_name);
		categoryPage.createCategory();

		String expectMessage = "The category code has already been taken.";
		String actualMessage = categoryPage.getFailedMessage();

		AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
	}
}
