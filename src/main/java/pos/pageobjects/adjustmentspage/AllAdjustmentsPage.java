package pos.pageobjects.adjustmentspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AllAdjustmentsPage {
    WebDriver driver;

    public AllAdjustmentsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web Elements
    @FindBy(xpath = "//a[contains(@href, '/adjustments/create')]")
    WebElement addButton;

    @FindBy(id = "adjustments-table")
    WebElement adjustmentsTable;

    @FindBy(css = "div.dataTables_filter input")
    WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"delete-adjustment\"]")
    WebElement deleteAdjustmentButton;

    @FindBy(xpath = "//*[@id=\"adjustments-table\"]/tbody/tr[1]/td[5]/a[1]")
    WebElement updateAdjustmentButton;

    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    // Page Methods
    public void goToCreateAdjustment() {
        addButton.click();
    }

    public boolean isAdjustmentsTableVisible() {
        return adjustmentsTable.isDisplayed();
    }

    public void searchForAdjustment(String adjustmentReference) {
        searchInput.sendKeys(adjustmentReference);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void deleteAdjustment() {
        deleteAdjustmentButton.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    public AdjustmentPage goToUpdateAdjustmentPage() {
        updateAdjustmentButton.click();
        AdjustmentPage updateAdjustmentPage = new AdjustmentPage(driver);
        return updateAdjustmentPage;
    }

    // Navigation
    public void navigateToAdjustmentsPage() {
        driver.get("http://127.0.0.1:8000/adjustments");
    }
}
