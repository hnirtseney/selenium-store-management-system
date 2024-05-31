package pos.tests.expenses.expensecategories;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.expensespage.CategoriesPage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateExpenseCategoryTest extends BaseTest {
    @DataProvider(name = "expenseCategoryData")
    public Object[][] getCategoryData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//expenses//ExpenseCategories.json");
        return data.stream().map(d -> new Object[]{d.get("expenseCategory")}).toArray(Object[][]::new);
    }

    @Test(dataProvider = "expenseCategoryData")
    public void createCreateExpenseCategoryTest(String expenseCategoryName) {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CategoriesPage categoriesPage = dashboardPage.goToCategoriesPage();
        categoriesPage.createExpenseCategory(expenseCategoryName);

        String expectMessage = "Expense Category Created!";
        String actualMessage = categoriesPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectMessage));
    }
}
