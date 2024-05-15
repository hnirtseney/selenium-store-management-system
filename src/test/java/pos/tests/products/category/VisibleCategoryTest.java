package pos.tests.products.category;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.DashboardPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.testcomponents.BaseTest;

public class VisibleCategoryTest extends BaseTest {
    @Test
    public void visibleCategoriesTable() {
        loginPage.goToLoginPage();
        DashboardPage dashboardPage = loginPage.login("super.admin@test.com", "12345678");
        CategoryPage categoryPage = dashboardPage.goToCategoryPage();
        categoryPage.waitForElementToAppear(By.id("product_categories-table"));

        Assert.assertTrue(categoryPage.productCategoriesTable.isDisplayed(), "Bảng danh sách categories không hiển thị.");
    }
}
