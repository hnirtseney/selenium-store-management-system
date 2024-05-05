//1. Bổ sung Verify qua Message


package pos.tests.products.category;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import pos.pageobjects.DashboardPage;
import pos.pageobjects.loginpage.LoginPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateCategoryTest extends BaseTest {
	@DataProvider(name = "loginAndCategoryData")
	public Object[][] getLoginAndCategoryData() throws IOException {
		List<HashMap<String, String>> loginData = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//pos//data//logindata//LoginSuccess.json");
		List<HashMap<String, String>> categoryData = getJsonDataToMap(
				System.getProperty("user.dir") + "//src//test//java//pos//data//products//Category.json");
		return new Object[][] { { loginData.get(0), categoryData.get(0) }, { loginData.get(0), categoryData.get(1) },
				{ loginData.get(0), categoryData.get(2) } };
	}

	@Test(dataProvider = "loginAndCategoryData")
	public void loginAndCreateCategoryTest(HashMap<String, String> loginInfo, HashMap<String, String> categoryInfo) {
		// Login
		loginPage.goToLoginPage();
		DashboardPage dashboardPage = loginPage.login(loginInfo.get("email"), loginInfo.get("password"));

		// Navigate to Category Page through Dashboard
		CategoryPage categoryPage = dashboardPage.goToCategoryPage();

		// Create Category
		categoryPage.openAddCategoryModal();
		categoryPage.fillCategoryForm(categoryInfo.get("category_code"), categoryInfo.get("category_name"));
		categoryPage.createCategory();
	}
}