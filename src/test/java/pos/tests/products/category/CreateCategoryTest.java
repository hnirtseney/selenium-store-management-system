//1. Bổ sung Verify qua Message

package pos.tests.products.category;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
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
                .map(d -> new Object[]{d.get("category_code"), d.get("category_name")})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "singleCategoryData")
    public Object[][] getSingleCategoryData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//products//Category.json");
        return new Object[][]{{data.get(0).get("category_code"), data.get(0).get("category_name")}};
    }

    public CategoryPage fillForm(String category_code, String category_name) {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CategoryPage categoryPage = dashboardPage.goToCategoryPage();
        categoryPage.openAddCategoryModal();
        categoryPage.inputCategoryCode(category_code);
        categoryPage.inputCategoryName(category_name);
        categoryPage.createCategory();
        return categoryPage;
    }

    @Test(
            dataProvider = "categoryData",
            groups = {"ProductsTest"}
    )
    public void createSuccessCategoryTest(String category_code, String category_name) {
        CategoryPage categoryPage = this.fillForm(category_code, category_name);

        String expectMessage = "Product Category Created!";
        String actualMessage = categoryPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }

    @Test(
            dataProvider = "singleCategoryData",
            priority = 2,
            groups = {"ProductsTest"}
    )
    public void createFailedCategorySuccess(String category_code, String category_name) {
        CategoryPage categoryPage = this.fillForm(category_code, category_name);

        String expectMessage = "The category code has already been taken.";
        String actualMessage = categoryPage.getFailedMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }
}
