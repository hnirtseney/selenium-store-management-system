package pos.pageobjects.adjustmentspage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdjustmentPage {
    WebDriver driver;

    public AdjustmentPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Web Elements
    @FindBy(xpath = "//a[contains(@href, '/adjustments/create')]")
    WebElement addButton;

    @FindBy(name = "reference")
    WebElement referenceInput;

    @FindBy(name = "date")
    WebElement dateInput;

    @FindBy(name = "note")
    WebElement noteTextArea;

    @FindBy(css = "button[type='submit']")
    WebElement createAdjustmentButton;

    // Page Methods
    public void clickAddButton() {
        addButton.click();
    }

//    public void enterReference(String reference) {
//        referenceInput.sendKeys(reference);
//    }

//    public void enterDate(String date) {
//        dateInput.sendKeys(date);
//    }

//    public void enterNote(String note) {
//        noteTextArea.sendKeys(note);
//    }

    public void submitAdjustment() {
        createAdjustmentButton.click();
    }

//    public void navigateToCreateAdjustmentPage() {
//        driver.get("http://localhost:8000/adjustments/create");
//    }
}
