package pos.tests.products.category;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.productspage.CategoryPage;
import pos.testcomponents.BaseTest;

public class VisibleCategoryTest extends BaseTest {
    @Test(
            groups = {"ProductsTest"}
    )
    public void visibleCategoriesTable() {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CategoryPage categoryPage = dashboardPage.goToCategoryPage();
        categoryPage.waitForElementToAppear(By.id("product_categories-table"));

        Assert.assertTrue(categoryPage.productCategoriesTable.isDisplayed(), "Bảng danh sách categories không hiển thị.");
    }
}
