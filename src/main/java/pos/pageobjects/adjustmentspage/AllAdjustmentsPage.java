package pos.pageobjects.adjustmentspage;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pos.abstractcomponents.AbstractComponents;

public class AllAdjustmentsPage extends AbstractComponents {
    WebDriver driver;

    public AllAdjustmentsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web Elements
    @FindBy(xpath = "//a[contains(@href, '/adjustments/create')]")
    WebElement addAdjustmentButton;

    @FindBy(xpath = "//*[@id=\"delete\"]")
    WebElement deleteAdjustmentButton;

    @FindBy(xpath = "//*[@id=\"adjustments-table\"]/tbody/tr[1]/td[5]/a[1]")
    WebElement updateAdjustmentButton;

    @FindBy(xpath = "//*[@id=\"swal2-title\"]")
    WebElement successMessage;

    // Page Methods
    public AdjustmentPage goToCreateAdjustment() {
        addAdjustmentButton.click();
        AdjustmentPage createAdjustmentPage = new AdjustmentPage(driver);
        return createAdjustmentPage;
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
}
