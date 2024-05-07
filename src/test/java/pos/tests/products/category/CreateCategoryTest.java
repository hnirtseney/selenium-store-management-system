//1. Bổ sung Verify qua Message

package pos.tests.products.category;

import org.testng.annotations.Test;
//import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import pos.pageobjects.DashboardPage;
//import pos.pageobjects.loginpage.LoginPage;
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

	@Test(dataProvider = "categoryData")
	public void loginAndCreateCategoryTest(String category_code, String category_name) {
		// Login
		loginPage.goToLoginPage();
		DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");

		// Navigate to Category Page through Dashboard
		CategoryPage categoryPage = dashboardPage.goToCategoryPage();

		// Create Category
		categoryPage.openAddCategoryModal();
		categoryPage.fillCategoryForm(category_code, category_name);
		categoryPage.createCategory();
	}
}


//	public Object[][] getLoginAndCategoryData() throws IOException {
//		List<HashMap<String, String>> loginData = getJsonDataToMap(
//				System.getProperty("user.dir") + "//src//test//java//pos//data//logindata//LoginSuccess.json");
//		List<HashMap<String, String>> categoryData = getJsonDataToMap(
//				System.getProperty("user.dir") + "//src//test//java//pos//data//products//Category.json");
//		return new Object[][] { { loginData.get(0), categoryData.get(0) }, { loginData.get(0), categoryData.get(1) },
//				{ loginData.get(0), categoryData.get(2) } };
//	}
