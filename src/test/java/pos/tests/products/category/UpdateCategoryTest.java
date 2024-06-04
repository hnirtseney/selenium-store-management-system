package pos.tests.products.category;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.pageobjects.productspage.DetailCategoryPage;
import pos.testcomponents.BaseTest;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class UpdateCategoryTest extends BaseTest {
    @DataProvider(name = "successData")
    public Object[][] provideSuccessData() throws FileNotFoundException {
        JsonElement jsonData = JsonParser.parseReader(new FileReader("src//test//java//pos//data//products//UpdateCategory.json"));
        JsonArray jsonArray = jsonData.getAsJsonArray();
        return new Object[][]{
                {jsonArray.get(0).getAsJsonObject().get("category_code").getAsString(), jsonArray.get(0).getAsJsonObject().get("category_name").getAsString()}
        };
    }

    @DataProvider(name = "failureData")
    public Object[][] provideFailureData() throws FileNotFoundException {
        JsonElement jsonData = JsonParser.parseReader(new FileReader("src//test//java//pos//data//products//UpdateCategory.json"));
        JsonArray jsonArray = jsonData.getAsJsonArray();
        return new Object[][]{
                {jsonArray.get(1).getAsJsonObject().get("category_code").getAsString(), jsonArray.get(1).getAsJsonObject().get("category_name").getAsString()}
        };
    }

    public DetailCategoryPage updateCategory(String categoryCode, String categoryName) {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CategoryPage categoryPage = dashboardPage.goToCategoryPage();
        DetailCategoryPage detailCategoryPage = categoryPage.clickUpdateCategoryButton();

        detailCategoryPage.setCategoryCode(categoryCode);
        detailCategoryPage.setCategoryName(categoryName);

        return detailCategoryPage;
    }

    @Test(
            dataProvider = "successData",
            groups = {"ProductsTest"}
    )
    public void updateCategorySuccessTest(String categoryCode, String categoryName) {
        DetailCategoryPage detailCategoryPage = this.updateCategory(categoryCode, categoryName);
        CategoryPage categoryPage = detailCategoryPage.clickUpdateBtn();
        String successMessage = categoryPage.getSuccessMessage();
        Assert.assertEquals(successMessage, "Product Category Updated!");
    }

    @Test(
            dataProvider = "failureData",
            priority = 5,
            groups = {"ProductsTest"}
    )
    public void updateCategoryFailedTest(String categoryCode, String categoryName) {
        DetailCategoryPage detailCategoryPage = this.updateCategory(categoryCode, categoryName);
        detailCategoryPage.clickUpdateBtn();
        String failedMessage = detailCategoryPage.getFailedMessage();
        Assert.assertEquals(failedMessage, "The category code has already been taken.");
    }
}
