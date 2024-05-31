package pos.pageobjects.expensespage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import pos.abstractcomponents.AbstractComponents;

public class CreateExpensePage extends AbstractComponents {

    WebDriver driver;
    Select select;
    @FindBy(xpath = "//select[@name='category_id']")
    WebElement selectExpenseCategory;
    @FindBy(xpath = "//input[@name='amount']")
    WebElement inputTotalAmount;
    @FindBy(xpath = "//button[contains(text(), 'Create Expense')]")
    WebElement createExpenseButton;

    public CreateExpensePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectCategory(String expenseCategory) {
        select = new Select(selectExpenseCategory);
        select.selectByVisibleText(expenseCategory);
    }

    public void enterAmount(String totalAmount) {
        inputTotalAmount.clear();
        inputTotalAmount.sendKeys(totalAmount);
    }

    public AllExpensesPage clickCreateExpenseButton() {
        createExpenseButton.click();
        return new AllExpensesPage(driver);
    }
}

