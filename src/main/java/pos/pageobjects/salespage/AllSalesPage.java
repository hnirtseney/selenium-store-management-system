package pos.pageobjects.salespage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllSalesPage extends AbstractComponents {
    WebDriver driver;

    // Constructor
    public AllSalesPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this); // This is important for @FindBy to work
    }

    // Locators with @FindBy
    @FindBy(css = "a.btn.btn-primary")
    WebElement addButton;

    @FindBy(id = "sales-table")
    WebElement salesTable;

    @FindBy(xpath = "//button[contains(text(), 'Excel')]")
    WebElement excelButton;

    @FindBy(xpath = "//button[contains(text(), 'Print')]")
    WebElement printButton;

    @FindBy(xpath = "//button[contains(text(), 'Reset')]")
    WebElement resetButton;

    @FindBy(xpath = "//button[contains(text(), 'Reload')]")
    WebElement reloadButton;

    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    // Page Actions
    public void clickAddButton() {
        addButton.click();
    }

    public WebElement getSalesTable() {
        return salesTable;
    }

    public void clickExcelButton() {
        excelButton.click();
    }

    public void clickPrintButton() {
        printButton.click();
    }

    public void clickResetButton() {
        resetButton.click();
    }

    public void clickReloadButton() {
        reloadButton.click();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    // Additional methods can be added to interact with other elements or perform more complex workflows
}
