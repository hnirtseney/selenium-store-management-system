package pos.tests.expenses.expense;

import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pos.form.expenses.CreateExpenseForm;
import pos.pageobjects.dashboardpage.DashboardPage;
import pos.pageobjects.expensespage.AllExpensesPage;
import pos.pageobjects.expensespage.CreateExpensePage;
import pos.testcomponents.BaseTest;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class CreateExpenseTest extends BaseTest {
    @DataProvider(name = "expenseData")
    public Object[][] getProductData() throws IOException {
        List<HashMap<String, String>> data = getJsonDataToMap(
                System.getProperty("user.dir") + "//src//test//java//pos//data//expenses//Expenses.json");
        return data.stream()
                .map(d -> new Object[]{new CreateExpenseForm(
                        d.get("expenseCategory"),
                        d.get("expenseTotalAmount")
                )})
                .toArray(Object[][]::new);
    }

    public CreateExpensePage fillForm(CreateExpenseForm form) {
        DashboardPage dashboardPage = this.gotoDashboardPage();
        CreateExpensePage createExpensePage = dashboardPage.goToCreateExpensePage();
        createExpensePage.selectCategory(form.expenseCategory);
        createExpensePage.enterAmount(form.expenseTotalAmount);

        return new CreateExpensePage(driver);
    }

    @Test(dataProvider = "expenseData")
    public void createCustomerTest(CreateExpenseForm form) {
        CreateExpensePage createExpensePage = this.fillForm(form);
        AllExpensesPage allExpensesPage = createExpensePage.clickCreateExpenseButton();

        String expectSuccessMessage = "Expense Created!";
        String actualMessage = allExpensesPage.getSuccessMessage();

        AssertJUnit.assertTrue(actualMessage.equalsIgnoreCase(expectSuccessMessage));
    }
}
