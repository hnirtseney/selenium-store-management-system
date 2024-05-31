package pos.pageobjects.expensespage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllExpensesPage extends AbstractComponents {
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;
    @FindBy(id = "delete")
    WebElement deleteExpenseButton;
    @FindBy(xpath = "//*[@id=\"expenses-table\"]")
    WebElement expensesTable;

    public AllExpensesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void deleteExpenseCategoryButton() {
        deleteExpenseButton.click();
    }
}
