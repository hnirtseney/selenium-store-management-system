package pos.tests.products.category;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.testcomponents.BaseTest;

public class VisibleCategoryTest extends BaseTest {
    @Test(dataProvider = "testAccount")
    public void visibleCategoriesTable(String username, String password) {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login(username, password);
        CategoryPage categoryPage = dashboardPage.goToCategoryPage();
        categoryPage.waitForElementToAppear(By.id("product_categories-table"));

        Assert.assertTrue(categoryPage.productCategoriesTable.isDisplayed(), "Bảng danh sách categories không hiển thị.");
    }
}
