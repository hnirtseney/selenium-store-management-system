package pos.pageobjects.expensespage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class CategoriesPage extends AbstractComponents {

    WebDriver driver;
    @FindBy(xpath = "/html/body/div[2]/div/main/div[1]/div/div/div/div/button")
    WebElement addCategoryButton;
    @FindBy(id = "expensecategories-table")
    WebElement expenseCategoryTable;
    @FindBy(xpath = "//*[@id=\"categoryCreateModal\"]/div/div/form/div[1]/div[1]/input")
    WebElement expenseCategoryName;
    @FindBy(xpath = "//*[@id=\"categoryCreateModal\"]/div/div/form/div[2]/button")
    WebElement submitCreateCategoruButton;
    @FindBy(xpath = "//*[@id=\"expensecategories-table\"]/tbody/tr/td[4]/a")
    WebElement editExpenseCategoryButton;
    @FindBy(id = "delete")
    WebElement deleteExpenseCategoryButton;
    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    public CategoriesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void createExpenseCategory(String categoryName) {
        addCategoryButton.click();
        expenseCategoryName.sendKeys(categoryName);
        submitCreateCategoruButton.click();
    }

    public void deleteExpenseCategoryButton() {
        deleteExpenseCategoryButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}